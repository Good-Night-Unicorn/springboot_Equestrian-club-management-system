<template>
	<div :style='{"padding":"20px 10px 20px 10px","fontSize":"15px"}'>
		<el-form
			:style='{"border":"1px solid #BFBFBF","padding":"40px 30% 20px 10%","background":"#FFFFFF"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			label-width="180px"
		>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='huiyuan'"  label="会员账号" prop="huiyuanzhanghao">
					<el-input v-model="ruleForm.huiyuanzhanghao" readonly						placeholder="会员账号" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='huiyuan'"  label="会员姓名" prop="huiyuanxingming">
					<el-input v-model="ruleForm.huiyuanxingming" 						placeholder="会员姓名" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='huiyuan'"  label="联系方式" prop="lianxifangshi">
					<el-input v-model="ruleForm.lianxifangshi" 						placeholder="联系方式" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='huiyuan'"  label="性别" prop="xingbie">
					<el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
						<el-option
							v-for="(item,index) in huiyuanxingbieOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='huiyuan'"  label="年龄" prop="nianling">
					<el-input v-model="ruleForm.nianling" 						placeholder="年龄" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='huiyuan'" label="头像" prop="touxiang">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
						@change="huiyuantouxiangUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='huiyuan'"  label="积分" prop="jifen">
					<el-input v-model="ruleForm.jifen" readonly						placeholder="积分" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='jiaolian'"  label="教练账号" prop="jiaolianzhanghao">
					<el-input v-model="ruleForm.jiaolianzhanghao" readonly						placeholder="教练账号" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='jiaolian'"  label="教练姓名" prop="jiaolianxingming">
					<el-input v-model="ruleForm.jiaolianxingming" 						placeholder="教练姓名" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='jiaolian'"  label="手机号" prop="shoujihao">
					<el-input v-model="ruleForm.shoujihao" 						placeholder="手机号" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='jiaolian'"  label="性别" prop="xingbie">
					<el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
						<el-option
							v-for="(item,index) in jiaolianxingbieOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='jiaolian'"  label="年龄" prop="nianling">
					<el-input v-model="ruleForm.nianling" 						placeholder="年龄" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='jiaolian'" label="头像" prop="touxiang">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
						@change="jiaoliantouxiangUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='jiaolian'"  label="擅长领域" prop="shanzhanglingyu">
					<el-input v-model="ruleForm.shanzhanglingyu" 						placeholder="擅长领域" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='mafang'"  label="马房账号" prop="mafangzhanghao">
					<el-input v-model="ruleForm.mafangzhanghao" readonly						placeholder="马房账号" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='mafang'"  label="马房姓名" prop="mafangxingming">
					<el-input v-model="ruleForm.mafangxingming" 						placeholder="马房姓名" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='mafang'"  label="手机号" prop="shoujihao">
					<el-input v-model="ruleForm.shoujihao" 						placeholder="手机号" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='mafang'"  label="性别" prop="xingbie">
					<el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
						<el-option
							v-for="(item,index) in mafangxingbieOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='mafang'"  label="年龄" prop="nianling">
					<el-input v-model="ruleForm.nianling" 						placeholder="年龄" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='mafang'" label="头像" prop="touxiang">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
						@change="mafangtouxiangUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='users'" label="用户名" prop="username">
					<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='users'" label="头像" prop="image">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="1"
						:multiple="false"
						:fileUrls="ruleForm.image?ruleForm.image:''"
						@change="usersimageUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"padding":"0","margin":"20px 0 0"}'>
					<el-button class="btn3" :style='{"border":"0px solid #ccc","cursor":"pointer","padding":"0 10px","margin":"0 10px 0 0","color":"#fff","borderRadius":"4px","background":"linear-gradient( 135deg, #097499 0%, #A5DDFD 100%)","width":"auto","fontSize":"16px","minWidth":"110px","height":"40px"}' type="primary" @click="onUpdateHandler">
						<span class="icon iconfont icon-xihuan" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","display":"none","height":"40px"}'></span>
						提交
					</el-button>
				</el-form-item>
		</el-form>
	</div>
</template>
<script>
// 校验引入
import { 
	isNumber,
	isIntNumer,
	isMobile,
} from "@/utils/validate";

export default {
	data() {
		return {
			ruleForm: {},
			flag: '',
			usersFlag: false,
			huiyuanxingbieOptions: [],
			jiaolianxingbieOptions: [],
			mafangxingbieOptions: [],
		};
	},
	mounted() {
		var table = this.$storage.get("sessionTable");
		this.flag = table;
		this.$http({
			url: `${this.$storage.get("sessionTable")}/session`,
			method: "get"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.ruleForm = data.data;
			} else {
				this.$message.error(data.msg);
			}
		});
		this.huiyuanxingbieOptions = "男,女".split(',')
		this.jiaolianxingbieOptions = "男,女".split(',')
		this.mafangxingbieOptions = "男,女".split(',')
	},
	methods: {
		huiyuantouxiangUploadChange(fileUrls) {
			this.ruleForm.touxiang = fileUrls;
		},
		jiaoliantouxiangUploadChange(fileUrls) {
			this.ruleForm.touxiang = fileUrls;
		},
		mafangtouxiangUploadChange(fileUrls) {
			this.ruleForm.touxiang = fileUrls;
		},
		usersimageUploadChange(fileUrls) {
			this.ruleForm.image = fileUrls;
		},
		onUpdateHandler() {
			if((!this.ruleForm.huiyuanzhanghao)&& 'huiyuan'==this.flag){
				this.$message.error('会员账号不能为空');
				return
			}


			if((!this.ruleForm.huiyuanxingming)&& 'huiyuan'==this.flag){
				this.$message.error('会员姓名不能为空');
				return
			}


			if((!this.ruleForm.mima)&& 'huiyuan'==this.flag){
				this.$message.error('密码不能为空');
				return
			}



			if( 'huiyuan' ==this.flag && this.ruleForm.lianxifangshi&&(!isMobile(this.ruleForm.lianxifangshi))){
				this.$message.error(`联系方式应输入手机格式`);
				return
			}




			if( 'huiyuan' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
				this.$message.error(`年龄应输入整数`);
				return
			}


			if(this.ruleForm.touxiang!=null) {
				this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
			}


			if( 'huiyuan' ==this.flag && this.ruleForm.jifen&&(!isNumber(this.ruleForm.jifen))){
				this.$message.error(`积分应输入数字`);
				return
			}




			if((!this.ruleForm.jiaolianzhanghao)&& 'jiaolian'==this.flag){
				this.$message.error('教练账号不能为空');
				return
			}


			if((!this.ruleForm.jiaolianxingming)&& 'jiaolian'==this.flag){
				this.$message.error('教练姓名不能为空');
				return
			}


			if((!this.ruleForm.mima)&& 'jiaolian'==this.flag){
				this.$message.error('密码不能为空');
				return
			}



			if( 'jiaolian' ==this.flag && this.ruleForm.shoujihao&&(!isMobile(this.ruleForm.shoujihao))){
				this.$message.error(`手机号应输入手机格式`);
				return
			}




			if( 'jiaolian' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
				this.$message.error(`年龄应输入整数`);
				return
			}


			if(this.ruleForm.touxiang!=null) {
				this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
			}


			if((!this.ruleForm.mafangzhanghao)&& 'mafang'==this.flag){
				this.$message.error('马房账号不能为空');
				return
			}


			if((!this.ruleForm.mafangxingming)&& 'mafang'==this.flag){
				this.$message.error('马房姓名不能为空');
				return
			}


			if((!this.ruleForm.mima)&& 'mafang'==this.flag){
				this.$message.error('密码不能为空');
				return
			}



			if( 'mafang' ==this.flag && this.ruleForm.shoujihao&&(!isMobile(this.ruleForm.shoujihao))){
				this.$message.error(`手机号应输入手机格式`);
				return
			}




			if( 'mafang' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
				this.$message.error(`年龄应输入整数`);
				return
			}


			if(this.ruleForm.touxiang!=null) {
				this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
			}
			if('users'==this.flag && this.ruleForm.username.trim().length<1) {
				this.$message.error(`用户名不能为空`);
				return	
			}
			if(this.flag=='users'){
				this.ruleForm.image = this.ruleForm.image.replace(new RegExp(this.$base.url,"g"),"")
			}
			this.$http({
				url: `${this.$storage.get("sessionTable")}/update`,
				method: "post",
				data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "修改信息成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							if(this.flag=='users'){
								this.$storage.set('headportrait',this.ruleForm.image)
							}
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>
<style lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
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
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
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
	
	.add-update-preview .btn3 {
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
			}
	
	.add-update-preview .btn3:hover {
				opacity: 0.8;
			}
	
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
