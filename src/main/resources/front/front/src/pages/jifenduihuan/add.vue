<template>
	<div class="add-update-preview">
		<el-form
			class="add-update-form"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
			>
			<el-form-item class="add-item" label="商品名称" prop="shangpinmingcheng">
				<el-input v-model="ruleForm.shangpinmingcheng" 
					placeholder="商品名称" clearable :disabled=" false  ||ro.shangpinmingcheng"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="商品分类" prop="shangpinfenlei">
				<el-input v-model="ruleForm.shangpinfenlei" 
					placeholder="商品分类" clearable :disabled=" false  ||ro.shangpinfenlei"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="商品图片" v-if="type!='cross' || (type=='cross' && !ro.shangpintupian)" prop="shangpintupian">
				<file-upload
					tip="点击上传商品图片"
					action="file/upload"
					:limit="3"
					:multiple="true"
					:fileUrls="ruleForm.shangpintupian?ruleForm.shangpintupian:''"
					@change="shangpintupianUploadChange"
					></file-upload>
			</el-form-item>
			<el-form-item class="add-item" v-else label="商品图片" prop="shangpintupian">
				<img v-if="ruleForm.shangpintupian.substring(0,4)=='http'" class="upload-img" v-bind:key="index" :src="ruleForm.shangpintupian.split(',')[0]">
				<img v-else class="upload-img" v-bind:key="index" v-for="(item,index) in ruleForm.shangpintupian.split(',')" :src="baseUrl+item">
			</el-form-item>
			<el-form-item class="add-item" label="兑换数量" prop="shangpinshuliang">
				<el-input v-model.number="ruleForm.shangpinshuliang" 
					placeholder="兑换数量" clearable :disabled=" false  ||ro.shangpinshuliang"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="所需积分" prop="suoxujifen">
				<el-input-number v-model="ruleForm.suoxujifen" placeholder="所需积分" :disabled=" false ||ro.suoxujifen"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="合计积分" prop="jifen">
				<el-input v-model="jifen" placeholder="合计积分" disabled></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="兑换时间" prop="duihuanshijian">
				<el-date-picker
					:disabled=" false  ||ro.duihuanshijian"
					value-format="yyyy-MM-dd HH:mm:ss"
					v-model="ruleForm.duihuanshijian" 
					type="datetime"
					placeholder="兑换时间">
				</el-date-picker>
			</el-form-item>
			<el-form-item class="add-item" label="会员账号" prop="huiyuanzhanghao">
				<el-input v-model="ruleForm.huiyuanzhanghao" 
					placeholder="会员账号" clearable :disabled=" false  ||ro.huiyuanzhanghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="会员姓名" prop="huiyuanxingming">
				<el-input v-model="ruleForm.huiyuanxingming" 
					placeholder="会员姓名" clearable :disabled=" false  ||ro.huiyuanxingming"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="会员积分" prop="huiyuanjifen">
				<el-input-number v-model="ruleForm.huiyuanjifen" placeholder="会员积分" :disabled=" false ||ro.huiyuanjifen"></el-input-number>
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
				uObject: null,
				baseUrl: '',
				ro:{
					shangpinmingcheng : false,
					shangpinfenlei : false,
					shangpintupian : false,
					shangpinshuliang : false,
					suoxujifen : false,
					jifen : false,
					duihuanshijian : false,
					huiyuanzhanghao : false,
					huiyuanxingming : false,
					huiyuanjifen : false,
				},
				type: '',
				userTableName: localStorage.getItem('UserTableName'),
				ruleForm: {
					shangpinmingcheng: '',
					shangpinfenlei: '',
					shangpintupian: '',
					shangpinshuliang: '',
					suoxujifen: '',
					jifen: '',
					duihuanshijian: '',
					huiyuanzhanghao: '',
					huiyuanxingming: '',
					huiyuanjifen: '',
				},


				rules: {
					shangpinmingcheng: [
					],
					shangpinfenlei: [
					],
					shangpintupian: [
					],
					shangpinshuliang: [
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
					suoxujifen: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					jifen: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					duihuanshijian: [
					],
					huiyuanzhanghao: [
					],
					huiyuanxingming: [
					],
					huiyuanjifen: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
				},
				centerType: false,
			};
		},
		computed: {


			jifen:{
				get: function () {
					return 1*this.ruleForm.shangpinshuliang*this.ruleForm.suoxujifen
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
			this.ruleForm.duihuanshijian = this.getCurDateTime()
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
						if(o=='shangpinmingcheng'){
							this.ruleForm.shangpinmingcheng = obj[o];
							this.ro.shangpinmingcheng = true;
							continue;
						}
						if(o=='shangpinfenlei'){
							this.ruleForm.shangpinfenlei = obj[o];
							this.ro.shangpinfenlei = true;
							continue;
						}
						if(o=='shangpintupian'){
							this.ruleForm.shangpintupian = obj[o].split(",")[0];
							this.ro.shangpintupian = true;
							continue;
						}
						if(o=='shangpinshuliang'){
							this.ruleForm.shangpinshuliang = obj[o];
							this.ro.shangpinshuliang = true;
							continue;
						}
						if(o=='suoxujifen'){
							this.ruleForm.suoxujifen = obj[o];
							this.ro.suoxujifen = true;
							continue;
						}
						if(o=='jifen'){
							this.ruleForm.jifen = obj[o];
							this.ro.jifen = true;
							continue;
						}
						if(o=='duihuanshijian'){
							this.ruleForm.duihuanshijian = obj[o];
							this.ro.duihuanshijian = true;
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
						if(o=='huiyuanjifen'){
							this.ruleForm.huiyuanjifen = obj[o];
							this.ro.huiyuanjifen = true;
							continue;
						}
					}
					this.ruleForm.shangpinshuliang = 0;
					this.ro.shangpinshuliang = false;
				}else if(type=='edit'){
					this.info()
				}
				// 获取用户信息
				this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						var json = res.data.data;
						this.uObject = res.data.data;
						if((json.huiyuanzhanghao!=''&&json.huiyuanzhanghao) || json.huiyuanzhanghao==0){
							this.ruleForm.huiyuanzhanghao = json.huiyuanzhanghao;
							this.ro.huiyuanzhanghao = true;
						}
						if((json.huiyuanxingming!=''&&json.huiyuanxingming) || json.huiyuanxingming==0){
							this.ruleForm.huiyuanxingming = json.huiyuanxingming;
							this.ro.huiyuanxingming = true;
						}
						if((json.jifen!=''&&json.jifen) || json.jifen==0){
							this.ruleForm.huiyuanjifen = json.jifen;
							this.ro.huiyuanjifen = true;
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
				this.$http.get(`jifenduihuan/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.ruleForm = res.data.data;
					}
				});
			},
			// 提交
			async onSubmit() {
				if((parseFloat(this.uObject.jifen) - parseFloat(this.ruleForm.jifen)) < 0){
					this.$message({
						message: "您的合计积分不足",
						type: 'error',
						duration: 1500
					});
					return false
				}
				this.ruleForm.jifen = this.jifen
				if(!this.ruleForm.shangpinshuliang){
					this.$message.error("兑换数量不能为空");
					return
				}
				var obj = JSON.parse(localStorage.getItem('crossObj'));
				var table = localStorage.getItem('crossTable');
				obj.shangpinshuliang = obj.shangpinshuliang - this.ruleForm.shangpinshuliang
				if(obj.shangpinshuliang<0){
					this.$message.error("兑换数量不足");
					return
				}
				if(this.ruleForm.jifen>this.ruleForm.huiyuanjifen){
					this.$message.error("合计积分不能超过会员积分");
					return
				}
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
						// 跨表计算
						var obj = JSON.parse(localStorage.getItem('crossObj'));
						var table = localStorage.getItem('crossTable');

						obj.shangpinshuliang = parseFloat(obj.shangpinshuliang) - parseFloat(this.ruleForm.shangpinshuliang)

						await this.$http.post(table+`/update`,obj).then(res => {});
						await this.$http.post(`jifenduihuan/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(async res => {
							if (res.data.code == 0) {
								if(this.uObject.jifen>=0){
									this.uObject.jifen = parseFloat(this.uObject.jifen) - parseFloat(this.ruleForm.jifen)
									await this.$http.post(this.userTableName+'/update', this.uObject).then(res => {});
									localStorage.setItem('sessionForm',JSON.stringify(this.uObject))
								}
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
			shangpintupianUploadChange(fileUrls) {
				this.ruleForm.shangpintupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
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
