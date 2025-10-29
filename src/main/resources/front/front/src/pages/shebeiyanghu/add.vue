<template>
	<div class="add-update-preview">
		<el-form
			class="add-update-form"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
			>
			<el-form-item class="add-item" label="设备编号" prop="shebeibianhao">
				<el-input v-model="ruleForm.shebeibianhao" 
					placeholder="设备编号" clearable :disabled=" false  ||ro.shebeibianhao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="设备名称" prop="shebeimingcheng">
				<el-input v-model="ruleForm.shebeimingcheng" 
					placeholder="设备名称" clearable :disabled=" false  ||ro.shebeimingcheng"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="设备类型" prop="shebeileixing">
				<el-input v-model="ruleForm.shebeileixing" 
					placeholder="设备类型" clearable :disabled=" false  ||ro.shebeileixing"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="养护图片" v-if="type!='cross' || (type=='cross' && !ro.yanghutupian)" prop="yanghutupian">
				<file-upload
					tip="点击上传养护图片"
					action="file/upload"
					:limit="3"
					:multiple="true"
					:fileUrls="ruleForm.yanghutupian?ruleForm.yanghutupian:''"
					@change="yanghutupianUploadChange"
					></file-upload>
			</el-form-item>
			<el-form-item class="add-item" v-else label="养护图片" prop="yanghutupian">
				<img v-if="ruleForm.yanghutupian.substring(0,4)=='http'" class="upload-img" v-bind:key="index" :src="ruleForm.yanghutupian.split(',')[0]">
				<img v-else class="upload-img" v-bind:key="index" v-for="(item,index) in ruleForm.yanghutupian.split(',')" :src="baseUrl+item">
			</el-form-item>
			<el-form-item class="add-item" label="养护数量" prop="yanghushuliang">
				<el-input v-model.number="ruleForm.yanghushuliang" 
					placeholder="养护数量" clearable :disabled=" false  ||ro.yanghushuliang"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="设备型号" prop="shebeixinghao">
				<el-input v-model="ruleForm.shebeixinghao" 
					placeholder="设备型号" clearable :disabled=" false  ||ro.shebeixinghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="养护时间" prop="yanghushijian">
				<el-date-picker
					:disabled=" false  ||ro.yanghushijian"
					format="yyyy 年 MM 月 dd 日"
					value-format="yyyy-MM-dd"
					v-model="ruleForm.yanghushijian" 
					type="date"
					placeholder="养护时间">
				</el-date-picker> 
			</el-form-item>
			<el-form-item class="add-item" label="马房账号" prop="mafangzhanghao">
				<el-input v-model="ruleForm.mafangzhanghao" 
					placeholder="马房账号" clearable :disabled=" false  ||ro.mafangzhanghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="马房姓名" prop="mafangxingming">
				<el-input v-model="ruleForm.mafangxingming" 
					placeholder="马房姓名" clearable :disabled=" false  ||ro.mafangxingming"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="养护记录" prop="yanghujilu">
				<el-input
					type="textarea"
					:rows="8"
					placeholder="养护记录"
					v-model="ruleForm.yanghujilu">
					</el-input>
			</el-form-item>

			<el-form-item class="add-btn-item">
				<el-button class="submitBtn"  type="primary" @click="onSubmit">
					<span class="icon iconfont icon-kaitongfuwu"></span>
					<span class="text">更新信息</span>
				</el-button>
				<el-button class="closeBtn" @click="back()">
					<span class="icon iconfont icon-shanchu1"></span>
					<span class="text">取消</span>
				</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				id: '',
				baseUrl: '',
				ro:{
					shebeibianhao : false,
					shebeimingcheng : false,
					shebeileixing : false,
					yanghutupian : false,
					yanghushuliang : false,
					shebeixinghao : false,
					yanghujilu : false,
					yanghushijian : false,
					mafangzhanghao : false,
					mafangxingming : false,
				},
				type: '',
				userTableName: localStorage.getItem('UserTableName'),
				ruleForm: {
					shebeibianhao: '',
					shebeimingcheng: '',
					shebeileixing: '',
					yanghutupian: '',
					yanghushuliang: '',
					shebeixinghao: '',
					yanghujilu: '',
					yanghushijian: '',
					mafangzhanghao: '',
					mafangxingming: '',
				},


				rules: {
					shebeibianhao: [
					],
					shebeimingcheng: [
						{ required: true, message: '设备名称不能为空', trigger: 'blur' },
					],
					shebeileixing: [
					],
					yanghutupian: [
					],
					yanghushuliang: [
						{ required: true, message: '养护数量不能为空', trigger: 'blur' },
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
					shebeixinghao: [
						{ required: true, message: '设备型号不能为空', trigger: 'blur' },
					],
					yanghujilu: [
					],
					yanghushijian: [
					],
					mafangzhanghao: [
					],
					mafangxingming: [
					],
				},
				centerType: false,
			};
		},
		computed: {



		},
		components: {
		},
		created() {
			if(this.$route.query.centerType){
				this.centerType = true
			}
			//this.bg();
			let type = this.$route.query.type ? this.$route.query.type : '';
			this.init(type);
			this.baseUrl = this.$config.baseUrl;
			this.ruleForm.yanghushijian = this.getCurDate()
		},
		methods: {
			getMakeZero(s) {
				return s < 10 ? '0' + s : s;
			},
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(type) {
				this.type = type;
				if(type=='cross'){
					var obj = JSON.parse(localStorage.getItem('crossObj'));
					for (var o in obj){
						if(o=='shebeibianhao'){
							this.ruleForm.shebeibianhao = obj[o];
							this.ro.shebeibianhao = true;
							continue;
						}
						if(o=='shebeimingcheng'){
							this.ruleForm.shebeimingcheng = obj[o];
							this.ro.shebeimingcheng = true;
							continue;
						}
						if(o=='shebeileixing'){
							this.ruleForm.shebeileixing = obj[o];
							this.ro.shebeileixing = true;
							continue;
						}
						if(o=='yanghutupian'){
							this.ruleForm.yanghutupian = obj[o].split(",")[0];
							this.ro.yanghutupian = true;
							continue;
						}
						if(o=='yanghushuliang'){
							this.ruleForm.yanghushuliang = obj[o];
							this.ro.yanghushuliang = true;
							continue;
						}
						if(o=='shebeixinghao'){
							this.ruleForm.shebeixinghao = obj[o];
							this.ro.shebeixinghao = true;
							continue;
						}
						if(o=='yanghujilu'){
							this.ruleForm.yanghujilu = obj[o];
							this.ro.yanghujilu = true;
							continue;
						}
						if(o=='yanghushijian'){
							this.ruleForm.yanghushijian = obj[o];
							this.ro.yanghushijian = true;
							continue;
						}
						if(o=='mafangzhanghao'){
							this.ruleForm.mafangzhanghao = obj[o];
							this.ro.mafangzhanghao = true;
							continue;
						}
						if(o=='mafangxingming'){
							this.ruleForm.mafangxingming = obj[o];
							this.ro.mafangxingming = true;
							continue;
						}
					}
				}else if(type=='edit'){
					this.info()
				}
				// 获取用户信息
				this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						var json = res.data.data;
						if((json.mafangzhanghao!=''&&json.mafangzhanghao) || json.mafangzhanghao==0){
							this.ruleForm.mafangzhanghao = json.mafangzhanghao;
							this.ro.mafangzhanghao = true;
						}
						if((json.mafangxingming!=''&&json.mafangxingming) || json.mafangxingming==0){
							this.ruleForm.mafangxingming = json.mafangxingming;
							this.ro.mafangxingming = true;
						}
					}
				});

				if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
					localStorage.removeItem('raffleType')
					setTimeout(() => {
						this.onSubmit()
					}, 300)
				}
			},

			// 多级联动参数
			// 多级联动参数
			info() {
				this.$http.get(`shebeiyanghu/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.ruleForm = res.data.data;
					}
				});
			},
			// 提交
			async onSubmit() {
				await this.$refs["ruleForm"].validate(async valid => {
					if(valid) {
						if(this.type=='cross'){
							var statusColumnName = localStorage.getItem('statusColumnName');
							var statusColumnValue = localStorage.getItem('statusColumnValue');
							if(statusColumnName && statusColumnName!='') {
								var obj = JSON.parse(localStorage.getItem('crossObj'));
								if(!statusColumnName.startsWith("[")) {
									for (var o in obj){
										if(o==statusColumnName){
											obj[o] = statusColumnValue;
										}
									}
									var table = localStorage.getItem('crossTable');
									await this.$http.post(table+'/update', obj).then(res => {});
								}
							}
						}


						await this.$http.post(`shebeiyanghu/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(async res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
										
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.$router.go(-1);
			},
			yanghutupianUploadChange(fileUrls) {
				this.ruleForm.yanghutupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
			},
		}
	};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.add-update-preview {
		padding: 0 0 20px;
		margin: 0px auto;
		color: #666;
		background: #fff;
		width: 1200px;
		font-size: 16px;
		position: relative;
		.add-update-form {
			margin: 20px 0 0;
			width: 100%;
			position: relative;
			.add-item.el-form-item {
				padding: 0 0 10px;
				margin: 0 0 10px;
				background: none;
				border-color: #ccc;
				border-width: 0 0 1px;
				border-style: dashed;
				/deep/ .el-form-item__label {
					padding: 0 10px 0 0;
					color: #000000;
					font-weight: 500;
					width: 180px;
					font-size: inherit;
					line-height: 40px;
					text-align: center;
				}
				/deep/ .el-form-item__content {
					margin-left: 180px;
				}
				.el-input {
					width: auto;
				}
				.el-input /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: rgba(85, 85, 127, 1.0);
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input__inner {
					text-align: left;
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .is-disabled .el-input__inner {
					text-align: left;
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: rgba(85, 85, 127, 1.0);
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input-number__decrease {
					display: none;
				}
				.el-input-number /deep/ .el-input-number__increase {
					display: none;
				}
				.el-select {
					width: auto;
				}
				.el-select /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 10px;
					color: inherit;
					width: 100%;
					font-size: 16px;
					min-width: inherit !important;
					height: 40px;
				}
				.el-select /deep/ .is-disabled .el-input__inner {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 10px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor {
					width: auto;
				}
				.el-date-editor /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: auto;
					font-size: 16px;
					height: 40px;
				}
				/deep/ .el-upload--picture-card {
					background: transparent;
					border: 0;
					border-radius: 0;
					width: auto;
					height: auto;
					line-height: initial;
					vertical-align: middle;
				}
				/deep/ .upload .upload-img {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					object-fit: cover;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
				}
				/deep/ .el-upload-list .el-upload-list__item {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					object-fit: cover;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
					font-size: 14px;
					line-height: 1.8;
				}
				/deep/ .el-upload .el-icon-plus {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 0px;
					color: #999;
					background: #fff;
					object-fit: cover;
					width: 80px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
				}
				/deep/ .el-upload__tip {
					color: #888;
					font-size: 16px;
				}
				.el-textarea /deep/ .el-textarea__inner {
					border: 1px solid #ddd;
					border-radius: 0px;
					padding: 12px;
					box-shadow: none;
					color: inherit;
					width: auto;
					font-size: 16px;
					min-height: 150px;
					min-width: 48%;
					height: auto;
				}
				.el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
					border: 0px solid #ddd;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 12px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: auto;
					font-size: 16px;
					min-height: 150px;
					min-width: 50%;
					height: auto;
				}
				/deep/ .el-input__inner::placeholder {
					color: #9E9E9E;
					font-size: inherit;
				}
				/deep/ textarea::placeholder {
					color: #9E9E9E;
					font-size: inherit;
				}
				.editor {
					background-color: #fff;
					border-radius: 0;
					padding: 0;
					box-shadow: none;
					margin: 0;
					width: 80%;
					min-height: 250px;
					border-color: #ccc;
					border-width: 1px;
					border-style: solid;
					height: auto;
				}
				.upload-img {
					object-fit: cover;
					width: 100px;
					height: 100px;
				}
				.viewBtn {
					border: 0;
					cursor: pointer;
					border-radius: 0px;
					padding: 0 20px;
					margin: 0;
					color: #333;
					background: #03abe930;
					display: inline-block;
					width: auto;
					font-size: 14px;
					line-height: 34px;
					height: 34px;
				}
				.viewBtn:hover {
				}
				.unviewBtn {
					border: 0;
					cursor: pointer;
					padding: 0 20px;
					margin: 0;
					color: #333;
					display: inline-block;
					font-size: 14px;
					line-height: 34px;
					border-radius: 0px;
					outline: none;
					background: #ddd;
					width: auto;
					height: 34px;
				}
				.unviewBtn:hover {
					background: #eee;
				}
			}
			.add-btn-item {
				padding: 0;
				margin: 20px 0;
				.submitBtn {
					border: 0;
					cursor: pointer;
					border-radius: 2px;
					padding: 0 15px;
					margin: 0 20px 0 0;
					background: #66B9BB;
					display: inline-block;
					width: auto;
					font-size: 16px;
					line-height: 40px;
					height: 40px;
					.icon {
						color: #fff;
					}
					.text {
						color: #fff;
					}
				}
				.submitBtn:hover {
					opacity: 0.8;
					.icon {
					}
					.text {
					}
				}
				.closeBtn {
					border: 0px solid #ddd;
					cursor: pointer;
					padding: 0 15px;
					margin: 0 20px 0 0;
					display: inline-block;
					font-size: 16px;
					line-height: 40px;
					border-radius: 2px;
					background: #858585;
					width: auto;
					text-align: center;
					min-width: 110px;
					height: 40px;
					.icon {
						color: #fff;
					}
					.text {
						color: #fff;
					}
				}
				.closeBtn:hover {
					opacity: 0.8;
					.icon {
					}
					.text {
					}
				}
			}
		}
	}
	.el-date-editor.el-input {
		width: auto;
	}
</style>
