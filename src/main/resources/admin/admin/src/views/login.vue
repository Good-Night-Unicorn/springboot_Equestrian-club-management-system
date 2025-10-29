<template>
	<div>
		<div class="login-container">
			<el-form class="login_form animate__animated animate__backInDown">
				<div class="login_form2">
					<div class="title-container">基于springboot的马术俱乐部管理系统设计与实现</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							账号：
						</div>
						<input placeholder="请输入账号：" name="username" type="text" v-model="rulesForm.username">
					</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							密码：
						</div>
						<div class="password-box">
							<input placeholder="请输入密码：" name="password" :type="showPassword?'text':'password'" v-model="rulesForm.password">
							<span class="icon iconfont" :class="showPassword?'icon-liulan13':'icon-liulan17'" @click="showPassword=!showPassword"></span>
						</div>
					</div>
					<div class="list-code" v-if="loginType==1">
						<div class="lable">
							验证码：
						</div>
						<input placeholder="请输入验证码：" name="code" type="text" v-model="rulesForm.code">
						<div class="getCodeBt" @click="getRandCode(4)">
							<span :style="{color:item.color,transform:item.rotate,fontSize:item.size,padding: '0 3px',display:'inline-block'}" v-for="(item, index) in codes" :key="index">{{ item.num }}</span>
						</div>
					</div>

					<div class="list-item " v-if="roles.length>1">
						<div class="lable">
							角色：
						</div>
						<div prop="loginInRole" class="list-type">
							<el-radio v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">{{item.roleName}}</el-radio>
						</div>
					</div>

		
					<div class="login-btn">
						<div class="login-btn1">
							<el-button v-if="loginType==1" type="primary" @click="login()" class="loginInBt">登录</el-button>
						</div>
						<div class="login-btn2">
						</div>
						<div class="login-btn3">
						</div>
					</div>
				</div>
				<div class="idea-box1"></div>
				<div class="idea-box2">还没有账号？</div>
			</el-form>
		</div>
	</div>
</template>
<script>
	import 'animate.css'
	import menu from "@/utils/menu";
	export default {
		data() {
			return {
				verifyCheck2: false,
				flag: false,
				baseUrl:this.$base.url,
				loginType: 1,
				rulesForm: {
					username: "",
					password: "",
					role: "",
					code: '',
				},
				menus: [],
				roles: [],
				tableName: "",
				showPassword: false,
				codes: [{
					num: 1,
					color: '#000',
					rotate: '10deg',
					size: '16px'
				},{
					num: 2,
					color: '#000',
					rotate: '10deg',
					size: '16px'
				},{
					num: 3,
					color: '#000',
					rotate: '10deg',
					size: '16px'
				},{
					num: 4,
					color: '#000',
					rotate: '10deg',
					size: '16px'
				}],
			};
		},
		mounted() {
			this.getMenu();

		},
		created() {

			this.getRandCode()
		},
		destroyed() {
		},
		components: {
		},
		methods: {
			getMenu() {
				let params = {
					page: 1,
					limit: 1,
					sort: 'id',
				}

				this.$http({
					url: "menu/list",
					method: "get",
					params: params
				}).then(({
					data
				}) => {
					if (data && data.code === 0) {
						this.menus = JSON.parse(data.data.list[0].menujson);
						for (let i = 0; i < this.menus.length; i++) {
							if (this.menus[i].hasBackLogin=='是') {
								this.roles.push(this.menus[i])
							}
						}
						this.$storage.set("menus", this.menus);
					}
				})
			},

			//注册
			register(tableName){
				this.$storage.set("loginTable", tableName);
				this.$router.push({path:'/register',query:{pageFlag:'register'}})
			},
			// 登陆
			login() {
				let code = ''
				for(let i in this.codes) {
					code += this.codes[i].num
				}
				if (true && !this.rulesForm.code) {
					this.$message.error("请输入验证码");
					return;
				}
				if (true && this.rulesForm.code.toLowerCase() != code.toLowerCase()) {
					this.$message.error("验证码输入有误");
					this.getRandCode()
					return;
				}

				if (!this.rulesForm.username) {
					this.$message.error("请输入用户名");
					return;
				}
				if (!this.rulesForm.password) {
					this.$message.error("请输入密码");
					return;
				}
				if(this.roles.length>1) {
					if (!this.rulesForm.role) {
						this.$message.error("请选择角色");
						return;
					}

					let menus = this.menus;
					for (let i = 0; i < menus.length; i++) {
						if (menus[i].roleName == this.rulesForm.role) {
							this.tableName = menus[i].tableName;
						}
					}
				} else {
					this.tableName = this.roles[0].tableName;
					this.rulesForm.role = this.roles[0].roleName;
				}
		
				this.loginPost()
			},
			loginPost() {
				this.$http({
					url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
					method: "post"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.$storage.set("Token", data.token);
						this.$storage.set("role", this.rulesForm.role);
						this.$storage.set("sessionTable", this.tableName);
						this.$storage.set("adminName", this.rulesForm.username);
						this.$router.replace({ path: "/" });
					} else {
						this.$message.error(data.msg);
						this.getRandCode()
					}
				});
			},
			getRandCode(len = 4){
				this.randomString(len)
			},
			randomString(len = 4) {
				let chars = [
					"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
					"l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
					"w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G",
					"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
					"S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2",
					"3", "4", "5", "6", "7", "8", "9"
				]
				let colors = ["0", "1", "2","3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"]
				let sizes = ['14', '15', '16', '17', '18']

				let output = [];
				for (let i = 0; i < len; i++) {
					// 随机验证码
					let key = Math.floor(Math.random()*chars.length)
					this.codes[i].num = chars[key]
					// 随机验证码颜色
					let code = '#'
					for (let j = 0; j < 6; j++) {
						let key = Math.floor(Math.random()*colors.length)
						code += colors[key]
					}
					this.codes[i].color = code
					// 随机验证码方向
					let rotate = Math.floor(Math.random()*60)
					let plus = Math.floor(Math.random()*2)
					if(plus == 1) rotate = '-'+rotate
					this.codes[i].rotate = 'rotate('+rotate+'deg)'
					// 随机验证码字体大小
					let size = Math.floor(Math.random()*sizes.length)
					this.codes[i].size = sizes[size]+'px'
				}
			},
		}
	}
</script>

<style lang="scss" scoped>
.login-container {
	min-height: 100vh;
	position: relative;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20240926/85224f2f6e894e38b53ef41b2f35df09.png);
	background-repeat: no-repeat;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20240926/85224f2f6e894e38b53ef41b2f35df09.png);
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	align-items: center;
	background-position: center center;

	.login_form {
		border-radius: 0;
		padding: 0px 600px  0px 0;
		box-shadow: inset 0px 0px 0px 0px #000;
		margin: 0;
		z-index: 1000;
		background: rgba(2, 124, 159,0.6);
		display: flex;
		width: 1200px;
		min-height: 704px;
		position: relative;
		height: auto;
		.login_form2 {
			padding: 56px 10px 20px 0;
			flex-direction: column;
			background: #fff;
			display: flex;
			width: 100%;
		}
		.title-container {
			padding: 0 40px;
			margin: 0 0 10px 0;
			color: #333333;
			top: 60px;
			left: 0;
			background: none;
			font-weight: 500;
			width: 100%;
			font-size: 24px;
			line-height: 40px;
			text-align: center;
		}
		.list-item {
			margin: 15px 53px 15px 69px;
			background: none;
			display: flex;
			position: relative;
			align-items: center;
			height: 60px;
			.lable {
				color: #000;
				top: 33%;
				left: 15px;
				width: 120px;
				font-size: 16px;
				position: absolute!important;
				text-align: left;
				height: 60px;
			}
			input {
				border: 1px solid #333333;
				border-radius: 30px;
				padding: 0 72px;
				color: #333333;
				background: #F5F6F6;
				flex: 1;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			input:focus {
				border: 1px solid #333333;
				border-radius: 30px;
				padding: 0 72px;
				color: #333333;
				background: #F5F6F6;
				flex: 1;
				width: 500px;
				font-size: 16px;
				height: 60px;
			}
			.password-box {
				margin: 0;
				display: flex;
				width: 100%;
				line-height: 60px;
				align-items: center;
				height: 60px;
				input {
					border: 1px solid #333333;
					border-radius: 30px;
					padding: 0 72px;
					color: #333333;
					background: #F5F6F6;
					flex: 1;
					width: 500px;
					font-size: 16px;
					height: 60px;
				}
				input:focus {
					border: 1px solid #333333;
					border-radius: 30px;
					padding: 0 72px;
					color: #333333;
					background: #F5F6F6;
					flex: 1;
					width: 500px;
					font-size: 16px;
					height: 60px;
				}
				.iconfont {
					cursor: pointer;
					z-index: 1;
					color: #000;
					top: 0;
					font-size: 16px;
					position: absolute;
					right: 20px;
				}
			}
			input::placeholder {
				color: #999;
				font-size: 16px;
			}
		}
		.list-code {
			padding: 0;
			margin: 15px  auto;
			display: flex;
			width: 78%;
			align-items: center;
			position: relative;
			height: 60px;
			.lable {
				color: #000;
				top: 33%;
				left: 15px;
				width: 120px;
				font-size: 16px;
				position: absolute!important;
				text-align: left;
				height: 60px;
			}
			input {
				border: 1px solid #333333;
				border-radius: 30px;
				padding: 0 72px;
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
				padding: 0 72px;
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
			.getCodeBt {
				cursor: pointer;
				border-radius: 30px;
				margin: 0 0 0 10px;
				background: #017095;
				display: flex;
				width: 100px;
				border-color: rgba(0, 0, 0, 1);
				border-width: 0px 0px 0px 0;
				justify-content: center;
				align-items: center;
				border-style: solid;
				height: 60px;
			}
		}
		.list-type {
			border: 1px solid #333333;
			padding: 0 72px;
			margin: 15px 0;
			color: #333333;
			display: flex;
			font-size: 16px;
			min-height: 60px;
			line-height: 50px;
			flex-wrap: wrap;
			border-radius: 30px;
			background: #F5F6F6;
			flex: 1;
			width: 500px;
			align-items: center;
			/deep/ .el-radio__input .el-radio__inner {
				background: rgba(53, 53, 53, 0);
				border-color: #666;
			}
			/deep/ .el-radio__input.is-checked .el-radio__inner {
				background: #017095;
				border-color: #017095;
			}
			/deep/ .el-radio__label {
				color: #666;
				font-size: 16px;
			}
			/deep/ .el-radio__input.is-checked+.el-radio__label {
				color: #017095;
				font-size: 16px;
			}
		}
		.login-btn {
			margin: 30px auto;
			display: flex;
			width: 468px;
			justify-content: center;
			align-items: center;
			flex-wrap: wrap;
			.login-btn1 {
				width: 100%;
				order: 2;
			}
			.login-btn2 {
				padding: 0;
				bottom: 25%;
				display: flex;
				width: 50%;
				justify-content: center;
				align-items: center;
				position: absolute;
				right: 0;
				flex-wrap: wrap;
			}
			.login-btn3 {
				margin: 0 0 20px 0;
				width: 100%;
				order: 1;
			}
			.loginInBt {
				border: 0px solid rgba(0, 0, 0, 1);
				cursor: pointer;
				border-radius: 30px;
				padding: 0 10px;
				margin: 0 0 10px;
				color: #fff;
				background: linear-gradient( 117deg, #017095 0%, #B2DEFF 100%);
				font-weight: 600;
				width: 100%;
				font-size: 28px;
				height: 60px;
			}
			.loginInBt:hover {
				opacity: 0.8;
			}
			.register {
				border: 2px solid #FFFFFF;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 10px;
				margin: 0 10px;
				color:  #FFFFFF;
				background: none;
				width: auto;
				font-size: 16px;
				height: 34px;
			}
			.register:hover {
				opacity: 0.8;
			}
			.forget {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0;
				margin: 0 10px 10px 0;
				color: #000000;
				background: none;
				font-weight: 400;
				width: 100%;
				font-size: 16px;
				text-align: center;
				height: 34px;
			}
			.forget:hover {
				color: #017095;
				opacity: 1;
			}
		}
	}
	.idea-box1 {
		background-size: 150px 150px;
		bottom: 40%;
		font-weight: 600;
		font-size: 20px;
		right: 0;
		background-position: center center;
		border-radius: 10px;
		background-repeat: no-repeat;
		width: 50%;
		background-image: url(http://codegen.caihongy.cn/20241015/bb7a6681ff2b4606a7ada75b1ca06f3c.png);
		position: absolute;
		height: 150px;
		order: -2;
	}
	.idea-box2 {
		padding: 0;
		margin: 0px 0 40px 0;
		color: #FFFFFF;
		background: none;
		bottom: 29%;
		font-weight: 400;
		width: 50%;
		font-size: 16px;
		position: absolute;
		right: 0;
		text-align: center;
		order: -1;
	}
}

</style>
