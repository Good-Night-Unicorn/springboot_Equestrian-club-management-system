<template>
	<div>
		<div class="register-container">
			<el-form v-if="pageFlag=='register'" ref="ruleForm" class="rgs-form animate__animated animate__backInDown" :model="ruleForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">基于springboot的马术俱乐部管理系统设计与实现</div>
					<el-form-item class="list-item" v-if="tableName=='huiyuan'">
						<div class="lable" :class="changeRules('huiyuanzhanghao')?'required':''">会员账号：</div>
						<el-input  v-model="ruleForm.huiyuanzhanghao"  autocomplete="off" placeholder="会员账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='huiyuan'">
						<div class="lable" :class="changeRules('huiyuanxingming')?'required':''">会员姓名：</div>
						<el-input  v-model="ruleForm.huiyuanxingming"  autocomplete="off" placeholder="会员姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='huiyuan'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='huiyuan'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='huiyuan'">
						<div class="lable" :class="changeRules('lianxifangshi')?'required':''">联系方式：</div>
						<el-input  v-model="ruleForm.lianxifangshi"  autocomplete="off" placeholder="联系方式"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='huiyuan'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in huiyuanxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='huiyuan'">
						<div class="lable" :class="changeRules('nianling')?'required':''">年龄：</div>
						<el-input  v-model.number="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='huiyuan'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="huiyuantouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiaolian'">
						<div class="lable" :class="changeRules('jiaolianzhanghao')?'required':''">教练账号：</div>
						<el-input  v-model="ruleForm.jiaolianzhanghao"  autocomplete="off" placeholder="教练账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiaolian'">
						<div class="lable" :class="changeRules('jiaolianxingming')?'required':''">教练姓名：</div>
						<el-input  v-model="ruleForm.jiaolianxingming"  autocomplete="off" placeholder="教练姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiaolian'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiaolian'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiaolian'">
						<div class="lable" :class="changeRules('shoujihao')?'required':''">手机号：</div>
						<el-input  v-model="ruleForm.shoujihao"  autocomplete="off" placeholder="手机号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiaolian'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in jiaolianxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiaolian'">
						<div class="lable" :class="changeRules('nianling')?'required':''">年龄：</div>
						<el-input  v-model.number="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiaolian'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="jiaoliantouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiaolian'">
						<div class="lable" :class="changeRules('shanzhanglingyu')?'required':''">擅长领域：</div>
						<el-input  v-model="ruleForm.shanzhanglingyu"  autocomplete="off" placeholder="擅长领域"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='mafang'">
						<div class="lable" :class="changeRules('mafangzhanghao')?'required':''">马房账号：</div>
						<el-input  v-model="ruleForm.mafangzhanghao"  autocomplete="off" placeholder="马房账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='mafang'">
						<div class="lable" :class="changeRules('mafangxingming')?'required':''">马房姓名：</div>
						<el-input  v-model="ruleForm.mafangxingming"  autocomplete="off" placeholder="马房姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='mafang'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='mafang'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='mafang'">
						<div class="lable" :class="changeRules('shoujihao')?'required':''">手机号：</div>
						<el-input  v-model="ruleForm.shoujihao"  autocomplete="off" placeholder="手机号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='mafang'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in mafangxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='mafang'">
						<div class="lable" :class="changeRules('nianling')?'required':''">年龄：</div>
						<el-input  v-model.number="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='mafang'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="mafangtouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="login()">注册</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">已有账号，直接登录</div>
						</div>
					</div>
				</div>
				<div class="idea-box1"></div>
				<div class="idea-box2">输入您的账号和密码以注册帐户</div>
			</el-form>
		</div>
	</div>
</template>

<script>
	import 'animate.css'
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            huiyuanxingbieOptions: [],
            jiaolianxingbieOptions: [],
            mafangxingbieOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='huiyuan'){
				this.ruleForm = {
					huiyuanzhanghao: '',
					huiyuanxingming: '',
					mima: '',
					lianxifangshi: '',
					xingbie: '',
					nianling: '',
					touxiang: '',
					jifen: '0',
					sfsh: '',
					shhf: '',
				}
			}
			if(this.tableName=='jiaolian'){
				this.ruleForm = {
					jiaolianzhanghao: '',
					jiaolianxingming: '',
					mima: '',
					shoujihao: '',
					xingbie: '',
					nianling: '',
					touxiang: '',
					shanzhanglingyu: '',
				}
			}
			if(this.tableName=='mafang'){
				this.ruleForm = {
					mafangzhanghao: '',
					mafangxingming: '',
					mima: '',
					shoujihao: '',
					xingbie: '',
					nianling: '',
					touxiang: '',
				}
			}
			if ('huiyuan' == this.tableName) {
				this.rules.huiyuanzhanghao = [{ required: true, message: '请输入会员账号', trigger: 'blur' }]
			}
			if ('huiyuan' == this.tableName) {
				this.rules.huiyuanxingming = [{ required: true, message: '请输入会员姓名', trigger: 'blur' }]
			}
			if ('huiyuan' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('jiaolian' == this.tableName) {
				this.rules.jiaolianzhanghao = [{ required: true, message: '请输入教练账号', trigger: 'blur' }]
			}
			if ('jiaolian' == this.tableName) {
				this.rules.jiaolianxingming = [{ required: true, message: '请输入教练姓名', trigger: 'blur' }]
			}
			if ('jiaolian' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('mafang' == this.tableName) {
				this.rules.mafangzhanghao = [{ required: true, message: '请输入马房账号', trigger: 'blur' }]
			}
			if ('mafang' == this.tableName) {
				this.rules.mafangxingming = [{ required: true, message: '请输入马房姓名', trigger: 'blur' }]
			}
			if ('mafang' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			this.huiyuanxingbieOptions = "男,女".split(',')
			this.jiaolianxingbieOptions = "男,女".split(',')
			this.mafangxingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        huiyuantouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        jiaoliantouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        mafangtouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
			  if(this.tableName=='huiyuan'){
				  this.ruleForm.sfsh = '待审核'
			  }
			if((!this.ruleForm.huiyuanzhanghao) && `huiyuan` == this.tableName){
				this.$message.error(`会员账号不能为空`);
				return
			}
			if((!this.ruleForm.huiyuanxingming) && `huiyuan` == this.tableName){
				this.$message.error(`会员姓名不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `huiyuan` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `huiyuan` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if(`huiyuan` == this.tableName && this.ruleForm.lianxifangshi &&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
				this.$message.error(`联系方式应输入手机格式`);
				return
			}
			if(`huiyuan` == this.tableName && this.ruleForm.nianling &&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
				this.$message.error(`年龄应输入整数`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if((!this.ruleForm.jiaolianzhanghao) && `jiaolian` == this.tableName){
				this.$message.error(`教练账号不能为空`);
				return
			}
			if((!this.ruleForm.jiaolianxingming) && `jiaolian` == this.tableName){
				this.$message.error(`教练姓名不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `jiaolian` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `jiaolian` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if(`jiaolian` == this.tableName && this.ruleForm.shoujihao &&(!this.$validate.isMobile(this.ruleForm.shoujihao))){
				this.$message.error(`手机号应输入手机格式`);
				return
			}
			if(`jiaolian` == this.tableName && this.ruleForm.nianling &&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
				this.$message.error(`年龄应输入整数`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if((!this.ruleForm.mafangzhanghao) && `mafang` == this.tableName){
				this.$message.error(`马房账号不能为空`);
				return
			}
			if((!this.ruleForm.mafangxingming) && `mafang` == this.tableName){
				this.$message.error(`马房姓名不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `mafang` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `mafang` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if(`mafang` == this.tableName && this.ruleForm.shoujihao &&(!this.$validate.isMobile(this.ruleForm.shoujihao))){
				this.$message.error(`手机号应输入手机格式`);
				return
			}
			if(`mafang` == this.tableName && this.ruleForm.nianling &&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
				this.$message.error(`年龄应输入整数`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
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
.register-container {
	position: relative;
	background: url(http://codegen.caihongy.cn/20240926/85224f2f6e894e38b53ef41b2f35df09.png);
	background-repeat: no-repeat;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20240926/85224f2f6e894e38b53ef41b2f35df09.png);
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	align-items: center;
	background-position: 100% 100%;
	.rgs-form {
		.rgs-form2 {
		padding: 30px 20px 30px 0;
		flex-direction: column;
		background: #fff;
		display: flex;
		width: 100%;
		}
		border-radius: 0;
		padding: 0px 600px 0px 0;
		box-shadow: inset 0px 0px 0px 0px #000;
		margin: 80px auto;
		z-index: 1000;
		background: rgba(2, 124, 159,0.6);
		display: flex;
		width: 1200px;
		min-height: 704px;
		position: relative;
		height: auto;
		.title {
			padding: 0 0px;
			margin: 0 0 10px 0;
			color: #333333;
			background: none;
			font-weight: 500;
			width: 100%;
			font-size: 24px;
			line-height: 40px;
			text-align: center;
		}
		.list-item {
			margin: 15px 40px 15px 60px;
			display: flex;
			position: relative;
			height: auto;
			/deep/ .el-form-item__content {
				display: block;
				width: 100%;
			}
			.lable {
				z-index: 2;
				color: #000;
				top: 16%;
				left: 15px;
				width: 120px;
				font-size: 16px;
				position: absolute!important;
				text-align: right;
				height: 60px;
			}
			.el-input {
				width: 100%;
			}
			.el-input /deep/ .el-input__inner {
				border: 1px solid #333333;
				border-radius: 30px;
				padding: 0 22px 0 140px;
				color: #333333;
				background: #F5F6F6;
				flex: 1;
				width: 468px;
				font-size: 16px;
				height: 60px;
			}
			.el-input /deep/ .el-input__inner:focus {
				border: 1px solid #333333;
				border-radius: 30px;
				padding: 0 22px 0 140px;
				color: #333333;
				background: #F5F6F6;
				flex: 1;
				width: 500px ;
				font-size: 16px;
				height: 60px;
			}
			.el-select {
				width: 100%;
			}
			.el-select /deep/ .el-input__inner {
				border: 1px solid #333333;
				border-radius: 30px;
				padding: 0 22px 0 140px;
				color: #333333;
				background: #F5F6F6;
				flex: 1;
				width: 468px;
				font-size: 16px;
				height: 60px;
			}
			.el-select /deep/ .el-input__inner:focus {
				border: 1px solid #333333;
				border-radius: 30px;
				padding: 0 22px 0 140px;
				color: #333333;
				background: #F5F6F6;
				flex: 1;
				width: 500px;
				font-size: 16px;
				height: 60px;
			}
			.el-date-editor {
				width: 100%;
			}
			.el-date-editor /deep/ .el-input__inner {
				border: 1px solid #333333;
				border-radius: 30px;
				padding: 0 22px 0 140px;
				color: #333333;
				background: #F5F6F6;
				flex: 1;
				width: 468px;
				font-size: 16px;
				height: 60px;
			}
			.el-date-editor /deep/ .el-input__inner:focus {
				border: 1px solid #333333;
				border-radius: 30px;
				padding: 0 22px 0 140px;
				color: #333333;
				background: #F5F6F6;
				flex: 1;
				width: 500px;
				font-size: 16px;
				height: 60px;
			}
			.el-date-editor.el-input {
				width: 100%;
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
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				margin: 0 22px 0 140px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload-list .el-upload-list__item {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				margin: 0 22px 0 140px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload .el-icon-plus {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				margin: 0 22px 0 140px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload__tip {
				margin: 0 22px 0 140px;
				color: #666;
				font-size: 15px;
			}
			/deep/ .el-input__inner::placeholder {
				color: #999;
				font-size: 16px;
			}
			.required {
				position: relative;
			}
			.required::after{
				color: red;
				left: 115px;
				position: inherit;
				content: "*";
				order: -1;
			}
			.editor {
				border: 1px solid #000;
				border-radius: 0px!important;
				background: #fff;
				width: 100%;
				height: auto;
			}
			.editor>.avatar-uploader {
				line-height: 0;
				height: 0;
			}
		}
		.list-item.email {
			input {
				border: 1px solid #333333;
				border-radius: 30px;
				padding: 0 22px 0 140px;
				color: #333333;
				background: #F5F6F6;
				flex: 1;
				width: 250px!important;
				font-size: 16px;
				height: 60px;
			}
			input:focus {
				border: 1px solid #333333;
				border-radius: 30px;
				padding: 0 22px 0 140px;
				color: #333333;
				background: #F5F6F6;
				flex: 1;
				width: 250px!important;
				font-size: 16px;
				height: 60px;
			}
			input::placeholder {
				color: #999;
				font-size: 16px;
			}
			button {
				cursor: pointer;
				margin: 0 0 0 10px;
				color: #fff;
				display: flex;
				border-color: rgba(0, 0, 0, 1);
				border-radius: 30px;
				background: #017095;
				width: 120px;
				justify-content: center;
				border-width: 0px 0px 0px 0;
				align-items: center;
				border-style: solid;
				height: 60px;
			}
			button:hover {
				opacity: 0.8;
			}
		}
		.register-btn {
			margin: 20px 0 0;
			display: flex;
			width: 100%;
			flex-wrap: wrap;
		}
		.register-btn1 {
			display: flex;
			width: 100%;
			justify-content: center;
			order: 2;
		}
		.register-btn2 {
			width: 100%;
			order: 1;
		}
		.r-btn {
			border: 0px solid rgba(0, 0, 0, 1);
			cursor: pointer;
			border-radius: 30px;
			padding: 0 10px;
			margin: 0 0 10px;
			color: #fff;
			background: linear-gradient( 117deg, #017095 0%, #B2DEFF 100%);
			font-weight: 600;
			width: 468px;
			font-size: 28px;
			height: 60px;
		}
		.r-btn:hover {
			border: 0px solid rgba(0, 0, 0, 1);
			opacity: 0.8;
		}
		.r-login {
			cursor: pointer;
			padding: 0;
			margin: 0;
			color: #000000;
			display: inline-block;
			text-decoration: none;
			width: 100%;
			font-size: 15px;
			line-height: 40px;
			text-align: center;
		}
		.r-login:hover {
			opacity: 1;
		}
	}
	.idea-box1 {
		border-radius: 10px;
		background-repeat: no-repeat;
		background-size: cover;
		bottom: 45%;
		font-weight: 600;
		width: 150px;
		font-size: 20px;
		background-image: url(http://codegen.caihongy.cn/20241015/bb7a6681ff2b4606a7ada75b1ca06f3c.png);
		position: absolute;
		right: 18%;
		height: 150px;
		order: -2;
	}
	.idea-box2 {
		margin: 5px 0 40px;
		background: #fff;
		display: none;
		width: 100%;
		font-size: 16px;
		height: 30px;
		order: -1;
	}
}
	
	::-webkit-scrollbar {
	  display: none;
	}
</style>
