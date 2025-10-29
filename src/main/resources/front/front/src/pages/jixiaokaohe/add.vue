<template>
	<div class="add-update-preview">
		<el-form
			class="add-update-form"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
			>
			<el-form-item class="add-item" label="教练账号" prop="jiaolianzhanghao">
				<el-select  @change="jiaolianzhanghaoChange" v-model="ruleForm.jiaolianzhanghao" placeholder="请选择教练账号">
					<el-option
						v-for="(item,index) in jiaolianzhanghaoOptions"
						:key="index"
						:label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item class="add-item" label="教练姓名" prop="jiaolianxingming">
				<el-input v-model="ruleForm.jiaolianxingming" 
					placeholder="教练姓名" clearable :disabled=" false  ||ro.jiaolianxingming"></el-input>
			</el-form-item>
			<el-form-item class="add-item"  label="绩效月份" prop="jixiaoyuefen">
				<el-select v-model="ruleForm.jixiaoyuefen" placeholder="请选择绩效月份" :disabled=" false  ||ro.jixiaoyuefen" >
					<el-option
						v-for="(item,index) in jixiaoyuefenOptions"
						:key="index"
						:label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item class="add-item"  label="教练考勤" prop="jiaoliankaoqin">
				<el-select v-model="ruleForm.jiaoliankaoqin" placeholder="请选择教练考勤" :disabled=" false  ||ro.jiaoliankaoqin" >
					<el-option
						v-for="(item,index) in jiaoliankaoqinOptions"
						:key="index"
						:label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item class="add-item"  label="工作态度" prop="gongzuotaidu">
				<el-select v-model="ruleForm.gongzuotaidu" placeholder="请选择工作态度" :disabled=" false  ||ro.gongzuotaidu" >
					<el-option
						v-for="(item,index) in gongzuotaiduOptions"
						:key="index"
						:label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item class="add-item"  label="业务技能" prop="yewujineng">
				<el-select v-model="ruleForm.yewujineng" placeholder="请选择业务技能" :disabled=" false  ||ro.yewujineng" >
					<el-option
						v-for="(item,index) in yewujinengOptions"
						:key="index"
						:label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item class="add-item"  label="工作绩效" prop="gongzuojixiao">
				<el-select v-model="ruleForm.gongzuojixiao" placeholder="请选择工作绩效" :disabled=" false  ||ro.gongzuojixiao" >
					<el-option
						v-for="(item,index) in gongzuojixiaoOptions"
						:key="index"
						:label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item class="add-item" label="总得分" prop="zongdefen">
				<el-input v-model="zongdefen" placeholder="总得分" disabled></el-input>
			</el-form-item>
			<el-form-item class="add-item"  label="评价等级" prop="pingjiadengji">
				<el-select v-model="ruleForm.pingjiadengji" placeholder="请选择评价等级" :disabled=" false  ||ro.pingjiadengji" >
					<el-option
						v-for="(item,index) in pingjiadengjiOptions"
						:key="index"
						:label="item"
						:value="item">
					</el-option>
				</el-select>
			</el-form-item>
			<el-form-item class="add-item" label="图片" v-if="type!='cross' || (type=='cross' && !ro.tupian)" prop="tupian">
				<file-upload
					tip="点击上传图片"
					action="file/upload"
					:limit="3"
					:multiple="true"
					:fileUrls="ruleForm.tupian?ruleForm.tupian:''"
					@change="tupianUploadChange"
					></file-upload>
			</el-form-item>
			<el-form-item class="add-item" v-else label="图片" prop="tupian">
				<img v-if="ruleForm.tupian.substring(0,4)=='http'" class="upload-img" v-bind:key="index" :src="ruleForm.tupian.split(',')[0]">
				<img v-else class="upload-img" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="baseUrl+item">
			</el-form-item>
			<el-form-item class="add-item" label="点评" prop="dianping">
				<el-input
					type="textarea"
					:rows="8"
					placeholder="点评"
					v-model="ruleForm.dianping">
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
					jiaolianzhanghao : false,
					jiaolianxingming : false,
					jixiaoyuefen : false,
					jiaoliankaoqin : false,
					gongzuotaidu : false,
					yewujineng : false,
					gongzuojixiao : false,
					zongdefen : false,
					pingjiadengji : false,
					dianping : false,
					tupian : false,
				},
				type: '',
				userTableName: localStorage.getItem('UserTableName'),
				ruleForm: {
					jiaolianzhanghao: '',
					jiaolianxingming: '',
					jixiaoyuefen: '',
					jiaoliankaoqin: '',
					gongzuotaidu: '',
					yewujineng: '',
					gongzuojixiao: '',
					zongdefen: '',
					pingjiadengji: '',
					dianping: '',
					tupian: '',
				},
				jiaolianzhanghaoOptions: [],
				jixiaoyuefenOptions: [],
				jiaoliankaoqinOptions: [],
				gongzuotaiduOptions: [],
				yewujinengOptions: [],
				gongzuojixiaoOptions: [],
				pingjiadengjiOptions: [],


				rules: {
					jiaolianzhanghao: [
					],
					jiaolianxingming: [
					],
					jixiaoyuefen: [
						{ required: true, message: '绩效月份不能为空', trigger: 'blur' },
					],
					jiaoliankaoqin: [
						{ required: true, message: '教练考勤不能为空', trigger: 'blur' },
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
					gongzuotaidu: [
						{ required: true, message: '工作态度不能为空', trigger: 'blur' },
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
					yewujineng: [
						{ required: true, message: '业务技能不能为空', trigger: 'blur' },
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
					gongzuojixiao: [
						{ required: true, message: '工作绩效不能为空', trigger: 'blur' },
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
					zongdefen: [
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
					pingjiadengji: [
						{ required: true, message: '评价等级不能为空', trigger: 'blur' },
					],
					dianping: [
					],
					tupian: [
					],
				},
				centerType: false,
			};
		},
		computed: {
			zongdefen: {
				get: function () {
					return 0+parseFloat(this.ruleForm.jiaoliankaoqin==""?0:this.ruleForm.jiaoliankaoqin)+parseFloat(this.ruleForm.gongzuotaidu==""?0:this.ruleForm.gongzuotaidu)+parseFloat(this.ruleForm.yewujineng==""?0:this.ruleForm.yewujineng)+parseFloat(this.ruleForm.gongzuojixiao==""?0:this.ruleForm.gongzuojixiao) || 0
				}
			},



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
						if(o=='jixiaoyuefen'){
							this.ruleForm.jixiaoyuefen = obj[o];
							this.ro.jixiaoyuefen = true;
							continue;
						}
						if(o=='jiaoliankaoqin'){
							this.ruleForm.jiaoliankaoqin = obj[o];
							this.ro.jiaoliankaoqin = true;
							continue;
						}
						if(o=='gongzuotaidu'){
							this.ruleForm.gongzuotaidu = obj[o];
							this.ro.gongzuotaidu = true;
							continue;
						}
						if(o=='yewujineng'){
							this.ruleForm.yewujineng = obj[o];
							this.ro.yewujineng = true;
							continue;
						}
						if(o=='gongzuojixiao'){
							this.ruleForm.gongzuojixiao = obj[o];
							this.ro.gongzuojixiao = true;
							continue;
						}
						if(o=='zongdefen'){
							this.ruleForm.zongdefen = obj[o];
							this.ro.zongdefen = true;
							continue;
						}
						if(o=='pingjiadengji'){
							this.ruleForm.pingjiadengji = obj[o];
							this.ro.pingjiadengji = true;
							continue;
						}
						if(o=='dianping'){
							this.ruleForm.dianping = obj[o];
							this.ro.dianping = true;
							continue;
						}
						if(o=='tupian'){
							this.ruleForm.tupian = obj[o].split(",")[0];
							this.ro.tupian = true;
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
					}
				});
				this.$http.get('option/jiaolian/jiaolianzhanghao', {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.jiaolianzhanghaoOptions = res.data.data;
					}
				});
				this.jixiaoyuefenOptions = "一月,二月,三月,四月,五月,六月,七月,八月,九月,十月,十一月,十二月".split(',')
				this.jiaoliankaoqinOptions = "10,15,20,25".split(',')
				this.gongzuotaiduOptions = "10,15,20,25".split(',')
				this.yewujinengOptions = "10,15,20,25".split(',')
				this.gongzuojixiaoOptions = "10,15,20,25".split(',')
				this.pingjiadengjiOptions = "优秀,良好,一般,差".split(',')

				if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
					localStorage.removeItem('raffleType')
					setTimeout(() => {
						this.onSubmit()
					}, 300)
				}
			},
			// 下二随
			jiaolianzhanghaoChange () {
				this.$http.get('follow/jiaolian/jiaolianzhanghao?columnValue=' + this.ruleForm.jiaolianzhanghao, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						if(res.data.data.jiaolianxingming){
							this.ruleForm.jiaolianxingming = res.data.data.jiaolianxingming
						}
					}
				});
			},

			// 多级联动参数
			// 多级联动参数
			info() {
				this.$http.get(`jixiaokaohe/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.ruleForm = res.data.data;
					}
				});
			},
			// 提交
			async onSubmit() {
				this.ruleForm.zongdefen = this.zongdefen
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


						await this.$http.post(`jixiaokaohe/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(async res => {
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
			tupianUploadChange(fileUrls) {
				this.ruleForm.tupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
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
