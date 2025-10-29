<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item class="input" v-if="type!='info'"  label="课程名称" prop="kechengmingcheng" >
					<el-input v-model="ruleForm.kechengmingcheng" placeholder="课程名称" clearable  :readonly="ro.kechengmingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="课程名称" prop="kechengmingcheng" >
					<el-input v-model="ruleForm.kechengmingcheng" placeholder="课程名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="课程分类" prop="kechengfenlei" >
					<el-input v-model="ruleForm.kechengfenlei" placeholder="课程分类" clearable  :readonly="ro.kechengfenlei"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="课程分类" prop="kechengfenlei" >
					<el-input v-model="ruleForm.kechengfenlei" placeholder="课程分类" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.kechengfengmian" label="课程封面" prop="kechengfengmian" >
					<file-upload
						tip="点击上传课程封面"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.kechengfengmian?ruleForm.kechengfengmian:''"
						@change="kechengfengmianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.kechengfengmian" label="课程封面" prop="kechengfengmian" >
					<img v-if="ruleForm.kechengfengmian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.kechengfengmian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.kechengfengmian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="课程难度" prop="kechengnandu" >
					<el-input v-model="ruleForm.kechengnandu" placeholder="课程难度" clearable  :readonly="ro.kechengnandu"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="课程难度" prop="kechengnandu" >
					<el-input v-model="ruleForm.kechengnandu" placeholder="课程难度" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="预订时间" prop="yudingshijian" >
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.yudingshijian" 
						type="date"
						:readonly="ro.yudingshijian"
						placeholder="预订时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.yudingshijian" label="预订时间" prop="yudingshijian" >
					<el-input v-model="ruleForm.yudingshijian" placeholder="预订时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="教练账号" prop="jiaolianzhanghao" >
					<el-input v-model="ruleForm.jiaolianzhanghao" placeholder="教练账号" clearable  :readonly="ro.jiaolianzhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="教练账号" prop="jiaolianzhanghao" >
					<el-input v-model="ruleForm.jiaolianzhanghao" placeholder="教练账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="教练姓名" prop="jiaolianxingming" >
					<el-input v-model="ruleForm.jiaolianxingming" placeholder="教练姓名" clearable  :readonly="ro.jiaolianxingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="教练姓名" prop="jiaolianxingming" >
					<el-input v-model="ruleForm.jiaolianxingming" placeholder="教练姓名" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="课程费用" prop="kechengfeiyong" >
					<el-input-number v-model="ruleForm.kechengfeiyong" placeholder="课程费用" :disabled="ro.kechengfeiyong"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="课程费用" prop="kechengfeiyong" >
					<el-input v-model="ruleForm.kechengfeiyong" placeholder="课程费用" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="会员账号" prop="huiyuanzhanghao" >
					<el-input v-model="ruleForm.huiyuanzhanghao" placeholder="会员账号" clearable  :readonly="ro.huiyuanzhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="会员账号" prop="huiyuanzhanghao" >
					<el-input v-model="ruleForm.huiyuanzhanghao" placeholder="会员账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="会员姓名" prop="huiyuanxingming" >
					<el-input v-model="ruleForm.huiyuanxingming" placeholder="会员姓名" clearable  :readonly="ro.huiyuanxingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="会员姓名" prop="huiyuanxingming" >
					<el-input v-model="ruleForm.huiyuanxingming" placeholder="会员姓名" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item class="textarea" v-if="type!='info'" label="预订备注" prop="yudingbeizhu" >
				<el-input
					style="min-width: 200px; max-width: 600px;"
					type="textarea"
					:rows="8"
					placeholder="预订备注"
					v-model="ruleForm.yudingbeizhu" >
				</el-input>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.yudingbeizhu" label="预订备注" prop="yudingbeizhu" >
				<span class="text">{{ruleForm.yudingbeizhu}}</span>
			</el-form-item>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-xihuan"></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

	</div>
</template>
<script>
	import { 
		isNumber,
	} from "@/utils/validate";
	export default {
		data() {
			var validateNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isNumber(value)) {
					callback(new Error("请输入数字"));
				} else {
					callback();
				}
			};
			return {
				id: '',
				type: '',
			
			
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
					shhf: '',
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
						{ validator: validateNumber, trigger: 'blur' },
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
			};
		},
		props: ["parent"],
		computed: {



		},
		components: {
		},
		created() {
			this.ruleForm.yudingshijian = this.getCurDate()
		},
		methods: {
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(id,type) {
				if (id) {
					this.id = id;
					this.type = type;
				}
				if(this.type=='info'||this.type=='else'){
					this.info(id);
				}else if(this.type=='logistics'){
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
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
							this.ruleForm.kechengfengmian = obj[o];
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
				}
				// 获取用户信息
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
						if(((json.jiaolianzhanghao!=''&&json.jiaolianzhanghao) || json.jiaolianzhanghao==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.jiaolianzhanghao = json.jiaolianzhanghao
							this.ro.jiaolianzhanghao = true;
						}
						if(((json.jiaolianxingming!=''&&json.jiaolianxingming) || json.jiaolianxingming==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.jiaolianxingming = json.jiaolianxingming
							this.ro.jiaolianxingming = true;
						}
						if(((json.huiyuanzhanghao!=''&&json.huiyuanzhanghao) || json.huiyuanzhanghao==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.huiyuanzhanghao = json.huiyuanzhanghao
							this.ro.huiyuanzhanghao = true;
						}
						if(((json.huiyuanxingming!=''&&json.huiyuanxingming) || json.huiyuanxingming==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.huiyuanxingming = json.huiyuanxingming
							this.ro.huiyuanxingming = true;
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `kechengyuding/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					this.ruleForm.ispay = '未支付'
					if(this.ruleForm.kechengfengmian!=null) {
						this.ruleForm.kechengfengmian = this.ruleForm.kechengfengmian.replace(new RegExp(this.$base.url,"g"),"");
					}
					var objcross = this.$storage.getObj('crossObj');
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
									}
								}
							}
							
							await this.$http({
								url: `kechengyuding/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.kechengyudingCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
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
				this.parent.showFlag = true;
				this.parent.addOrUpdateFlag = false;
				this.parent.kechengyudingCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
			kechengfengmianUploadChange(fileUrls) {
				this.ruleForm.kechengfengmian = fileUrls;
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		padding: 30px 20px 20px 20px;
	}
	.add-update-preview {
		border: 1px solid #BFBFBF;
		padding: 40px 30% 20px 10%;
		background: #FFFFFF;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview /deep/ .el-form-item {
		border: 0px solid #eee;
		padding: 0;
		margin: 0 0 26px 0;
		display: inline-block;
		width: 100%;
	}
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #666;
		font-weight: 600;
		width: 180px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: 180px;
	}
	.add-update-preview .el-form-item span.text {
		border: 0px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: 360px;
		font-size: 15px;
		line-height: 34px;
		text-align: left;
		height: 34px;
	}
	
	.add-update-preview .el-input {
		width: 100%;
	}
	.add-update-preview .el-input /deep/ .el-input__inner {
		border: 1px dashed #bfbfbf;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		width: 100%;
		font-size: 16px;
		min-width: 360px;
		height: 40px;
	}
	.add-update-preview .el-input /deep/ .el-input__inner[readonly="readonly"] {
		border: 1px dashed #bfbfbf;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-input-number {
		text-align: left;
		width: 100%;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
		border: 1px dashed #bfbfbf;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		width: 100%;
		font-size: 16px;
		min-width: 360px;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .is-disabled .el-input__inner {
		text-align: left;
		border: 1px dashed #bfbfbf;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: 100%;
	}
	.add-update-preview .el-select /deep/ .el-input__inner {
		border: 1px dashed #bfbfbf;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-select /deep/ .is-disabled .el-input__inner {
		border: 1px dashed #bfbfbf;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-date-editor {
		width: 100%;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
		border: 1px dashed #bfbfbf;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 30px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
		border: 1px dashed #bfbfbf;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 30px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .viewBtn {
		border: 1px dashed #bfbfbf;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 30px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		text-align: left;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 1px dashed #bfbfbf;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 30px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 1px dashed #bfbfbf;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 30px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		text-align: left;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 34px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
		border: 1px dashed #bfbfbf;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
		border: 1px dashed #bfbfbf;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
		border: 1px dashed #bfbfbf;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	.add-update-preview /deep/ .el-upload__tip {
		color: #666;
		font-size: 15px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
		border: 1px dashed #bfbfbf;
		border-radius: 0px;
		padding: 12px;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 14px;
		min-width: 400px;
		height: 120px;
	}
	.add-update-preview .el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
				border: 1px dashed #bfbfbf;
				border-radius: 0px;
				padding: 12px;
				color: #666;
				background: #fff;
				width: 100%;
				font-size: 14px;
				min-width: 400px;
				height: 120px;
			}
	.add-update-preview .el-form-item.btn {
		padding: 0;
		margin: 20px 0 0;
		.btn1 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: linear-gradient( 135deg, #097499 0%, #A5DDFD 100%);
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: linear-gradient( 135deg, #097499 0%, #A5DDFD 100%);
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 34px;
			}
		}
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: linear-gradient( 135deg, #097499 0%, #A5DDFD 100%);
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: linear-gradient( 135deg, #097499 0%, #A5DDFD 100%);
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: linear-gradient( 135deg, #097499 0%, #A5DDFD 100%);
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn5:hover {
			opacity: 0.8;
		}
	}
</style>
