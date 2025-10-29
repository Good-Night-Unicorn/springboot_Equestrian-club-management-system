<template>
	<div class="add-update-preview">
		<el-form
			class="add-update-form"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
			>
			<el-form-item class="add-item" label="课程名称" prop="kechengmingcheng">
				<el-input v-model="ruleForm.kechengmingcheng" 
					placeholder="课程名称" clearable :disabled=" false  ||ro.kechengmingcheng"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="课程分类" prop="kechengfenlei">
				<el-input v-model="ruleForm.kechengfenlei" 
					placeholder="课程分类" clearable :disabled=" false  ||ro.kechengfenlei"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="课程封面" v-if="type!='cross' || (type=='cross' && !ro.kechengfengmian)" prop="kechengfengmian">
				<file-upload
					tip="点击上传课程封面"
					action="file/upload"
					:limit="3"
					:multiple="true"
					:fileUrls="ruleForm.kechengfengmian?ruleForm.kechengfengmian:''"
					@change="kechengfengmianUploadChange"
					></file-upload>
			</el-form-item>
			<el-form-item class="add-item" v-else label="课程封面" prop="kechengfengmian">
				<img v-if="ruleForm.kechengfengmian.substring(0,4)=='http'" class="upload-img" v-bind:key="index" :src="ruleForm.kechengfengmian.split(',')[0]">
				<img v-else class="upload-img" v-bind:key="index" v-for="(item,index) in ruleForm.kechengfengmian.split(',')" :src="baseUrl+item">
			</el-form-item>
			<el-form-item class="add-item" label="课程难度" prop="kechengnandu">
				<el-input v-model="ruleForm.kechengnandu" 
					placeholder="课程难度" clearable :disabled=" false  ||ro.kechengnandu"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="预订时间" prop="yudingshijian">
				<el-date-picker
					:disabled=" false  ||ro.yudingshijian"
					format="yyyy 年 MM 月 dd 日"
					value-format="yyyy-MM-dd"
					v-model="ruleForm.yudingshijian" 
					type="date"
					placeholder="预订时间">
				</el-date-picker> 
			</el-form-item>
			<el-form-item class="add-item" label="教练账号" prop="jiaolianzhanghao">
				<el-input v-model="ruleForm.jiaolianzhanghao" 
					placeholder="教练账号" clearable :disabled=" false  ||ro.jiaolianzhanghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="教练姓名" prop="jiaolianxingming">
				<el-input v-model="ruleForm.jiaolianxingming" 
					placeholder="教练姓名" clearable :disabled=" false  ||ro.jiaolianxingming"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="课程费用" prop="kechengfeiyong">
				<el-input-number v-model="ruleForm.kechengfeiyong" placeholder="课程费用" :disabled=" false ||ro.kechengfeiyong"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="会员账号" prop="huiyuanzhanghao">
				<el-input v-model="ruleForm.huiyuanzhanghao" 
					placeholder="会员账号" clearable :disabled=" false  ||ro.huiyuanzhanghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="会员姓名" prop="huiyuanxingming">
				<el-input v-model="ruleForm.huiyuanxingming" 
					placeholder="会员姓名" clearable :disabled=" false  ||ro.huiyuanxingming"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="预订备注" prop="yudingbeizhu">
				<el-input
					type="textarea"
					:rows="8"
					placeholder="预订备注"
					v-model="ruleForm.yudingbeizhu">
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
					kechengmingcheng : false,
					kechengfenlei : false,
					kechengfengmian : false,
					kechengnandu : false,
					yudingshijian : false,
					jiaolianzhanghao : false,
					jiaolianxingming : false,
					kechengfeiyong : false,
					huiyuanzhanghao : false,
					huiyuanxingming : false,
					yudingbeizhu : false,
					sfsh : false,
					shhf : false,
					ispay : false,
				},
				type: '',
				userTableName: localStorage.getItem('UserTableName'),
				ruleForm: {
					kechengmingcheng: '',
					kechengfenlei: '',
					kechengfengmian: '',
					kechengnandu: '',
					yudingshijian: '',
					jiaolianzhanghao: '',
					jiaolianxingming: '',
					kechengfeiyong: '',
					huiyuanzhanghao: '',
					huiyuanxingming: '',
					yudingbeizhu: '',
				},


				rules: {
					kechengmingcheng: [
						{ required: true, message: '课程名称不能为空', trigger: 'blur' },
					],
					kechengfenlei: [
						{ required: true, message: '课程分类不能为空', trigger: 'blur' },
					],
					kechengfengmian: [
					],
					kechengnandu: [
						{ required: true, message: '课程难度不能为空', trigger: 'blur' },
					],
					yudingshijian: [
					],
					jiaolianzhanghao: [
					],
					jiaolianxingming: [
					],
					kechengfeiyong: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					huiyuanzhanghao: [
					],
					huiyuanxingming: [
					],
					yudingbeizhu: [
					],
					sfsh: [
					],
					shhf: [
					],
					ispay: [
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
			this.ruleForm.yudingshijian = this.getCurDate()
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
						if(o=='kechengmingcheng'){
							this.ruleForm.kechengmingcheng = obj[o];
							this.ro.kechengmingcheng = true;
							continue;
						}
						if(o=='kechengfenlei'){
							this.ruleForm.kechengfenlei = obj[o];
							this.ro.kechengfenlei = true;
							continue;
						}
						if(o=='kechengfengmian'){
							this.ruleForm.kechengfengmian = obj[o].split(",")[0];
							this.ro.kechengfengmian = true;
							continue;
						}
						if(o=='kechengnandu'){
							this.ruleForm.kechengnandu = obj[o];
							this.ro.kechengnandu = true;
							continue;
						}
						if(o=='yudingshijian'){
							this.ruleForm.yudingshijian = obj[o];
							this.ro.yudingshijian = true;
							continue;
						}
						if(o=='jiaolianzhanghao'){
							this.ruleForm.jiaolianzhanghao = obj[o];
							this.ro.jiaolianzhanghao = true;
							continue;
						}
						if(o=='jiaolianxingming'){
							this.ruleForm.jiaolianxingming = obj[o];
							this.ro.jiaolianxingming = true;
							continue;
						}
						if(o=='kechengfeiyong'){
							this.ruleForm.kechengfeiyong = obj[o];
							this.ro.kechengfeiyong = true;
							continue;
						}
						if(o=='huiyuanzhanghao'){
							this.ruleForm.huiyuanzhanghao = obj[o];
							this.ro.huiyuanzhanghao = true;
							continue;
						}
						if(o=='huiyuanxingming'){
							this.ruleForm.huiyuanxingming = obj[o];
							this.ro.huiyuanxingming = true;
							continue;
						}
						if(o=='yudingbeizhu'){
							this.ruleForm.yudingbeizhu = obj[o];
							this.ro.yudingbeizhu = true;
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
						if((json.jiaolianzhanghao!=''&&json.jiaolianzhanghao) || json.jiaolianzhanghao==0){
							this.ruleForm.jiaolianzhanghao = json.jiaolianzhanghao;
							this.ro.jiaolianzhanghao = true;
						}
						if((json.jiaolianxingming!=''&&json.jiaolianxingming) || json.jiaolianxingming==0){
							this.ruleForm.jiaolianxingming = json.jiaolianxingming;
							this.ro.jiaolianxingming = true;
						}
						if((json.huiyuanzhanghao!=''&&json.huiyuanzhanghao) || json.huiyuanzhanghao==0){
							this.ruleForm.huiyuanzhanghao = json.huiyuanzhanghao;
							this.ro.huiyuanzhanghao = true;
						}
						if((json.huiyuanxingming!=''&&json.huiyuanxingming) || json.huiyuanxingming==0){
							this.ruleForm.huiyuanxingming = json.huiyuanxingming;
							this.ro.huiyuanxingming = true;
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
				this.$http.get(`kechengyuding/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
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


						await this.$http.post(`kechengyuding/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(async res => {
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
			kechengfengmianUploadChange(fileUrls) {
				this.ruleForm.kechengfengmian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
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
