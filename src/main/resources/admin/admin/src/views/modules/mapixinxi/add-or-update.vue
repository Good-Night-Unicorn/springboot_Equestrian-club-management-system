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
				<el-form-item class="input" v-if="type!='info'"  label="马匹名字" prop="mapimingzi" >
					<el-input v-model="ruleForm.mapimingzi" placeholder="马匹名字" clearable  :readonly="ro.mapimingzi"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="马匹名字" prop="mapimingzi" >
					<el-input v-model="ruleForm.mapimingzi" placeholder="马匹名字" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="马匹种类" prop="mapizhonglei" >
					<el-select :disabled="ro.mapizhonglei" v-model="ruleForm.mapizhonglei" placeholder="请选择马匹种类" >
						<el-option
							v-for="(item,index) in mapizhongleiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="马匹种类" prop="mapizhonglei" >
					<el-input v-model="ruleForm.mapizhonglei"
						placeholder="马匹种类" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="马匹编号" prop="mapibianhao" >
					<el-input v-model="ruleForm.mapibianhao" placeholder="马匹编号" clearable  :readonly="ro.mapibianhao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="马匹编号" prop="mapibianhao" >
					<el-input v-model="ruleForm.mapibianhao" placeholder="马匹编号" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.tupian" label="图片" prop="tupian" >
					<file-upload
						tip="点击上传图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.tupian?ruleForm.tupian:''"
						@change="tupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.tupian" label="图片" prop="tupian" >
					<img v-if="ruleForm.tupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.tupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="马匹性别" prop="mapixingbie" >
					<el-select :disabled="ro.mapixingbie" v-model="ruleForm.mapixingbie" placeholder="请选择马匹性别" >
						<el-option
							v-for="(item,index) in mapixingbieOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="马匹性别" prop="mapixingbie" >
					<el-input v-model="ruleForm.mapixingbie"
						placeholder="马匹性别" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="身体状况" prop="shentizhuangkuang" >
					<el-select :disabled="ro.shentizhuangkuang" v-model="ruleForm.shentizhuangkuang" placeholder="请选择身体状况" >
						<el-option
							v-for="(item,index) in shentizhuangkuangOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="身体状况" prop="shentizhuangkuang" >
					<el-input v-model="ruleForm.shentizhuangkuang"
						placeholder="身体状况" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="马匹年龄" prop="mapinianling" >
					<el-input v-model.number="ruleForm.mapinianling" placeholder="马匹年龄" clearable  :readonly="ro.mapinianling"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="马匹年龄" prop="mapinianling" >
					<el-input v-model="ruleForm.mapinianling" placeholder="马匹年龄" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="是否接种" prop="shifoujiezhong" >
					<el-select :disabled="ro.shifoujiezhong" v-model="ruleForm.shifoujiezhong" placeholder="请选择是否接种" >
						<el-option
							v-for="(item,index) in shifoujiezhongOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="是否接种" prop="shifoujiezhong" >
					<el-input v-model="ruleForm.shifoujiezhong"
						placeholder="是否接种" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="马匹性情" prop="mapixingqing" >
					<el-input v-model="ruleForm.mapixingqing" placeholder="马匹性情" clearable  :readonly="ro.mapixingqing"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="马匹性情" prop="mapixingqing" >
					<el-input v-model="ruleForm.mapixingqing" placeholder="马匹性情" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="马匹爱好" prop="mapiaihao" >
					<el-input v-model="ruleForm.mapiaihao" placeholder="马匹爱好" clearable  :readonly="ro.mapiaihao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="马匹爱好" prop="mapiaihao" >
					<el-input v-model="ruleForm.mapiaihao" placeholder="马匹爱好" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'" label="教练账号" prop="jiaolianzhanghao" >
					<el-select :disabled="ro.jiaolianzhanghao" @change="jiaolianzhanghaoChange" v-model="ruleForm.jiaolianzhanghao" placeholder="请选择教练账号">
						<el-option
							v-for="(item,index) in jiaolianzhanghaoOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.jiaolianzhanghao" label="教练账号" prop="jiaolianzhanghao" >
					<el-input v-model="ruleForm.jiaolianzhanghao" placeholder="教练账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="教练姓名" prop="jiaolianxingming" >
					<el-input v-model="ruleForm.jiaolianxingming" placeholder="教练姓名" clearable  :readonly="ro.jiaolianxingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="教练姓名" prop="jiaolianxingming" >
					<el-input v-model="ruleForm.jiaolianxingming" placeholder="教练姓名" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item v-if="type!='info'"  label="马匹详情" prop="mapixiangqing" >
				<editor 
					style="min-width: 200px; max-width: 600px;"
					v-model="ruleForm.mapixiangqing" 
					class="editor" 
					action="file/upload">
				</editor>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.mapixiangqing" label="马匹详情" prop="mapixiangqing" >
				<span class="text" v-html="ruleForm.mapixiangqing"></span>
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
		isIntNumer,
	} from "@/utils/validate";
	export default {
		data() {
			var validateIntNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isIntNumer(value)) {
					callback(new Error("请输入整数"));
				} else {
					callback();
				}
			};
			return {
				id: '',
				type: '',
			
			
				ro:{
					mapimingzi : false,
					mapizhonglei : false,
					mapibianhao : false,
					tupian : false,
					mapixingbie : false,
					shentizhuangkuang : false,
					mapinianling : false,
					shifoujiezhong : false,
					mapixingqing : false,
					mapiaihao : false,
					mapixiangqing : false,
					jiaolianzhanghao : false,
					jiaolianxingming : false,
				},
			
				ruleForm: {
					mapimingzi: '',
					mapizhonglei: '',
					mapibianhao: '',
					tupian: '',
					mapixingbie: '',
					shentizhuangkuang: '',
					mapinianling: '',
					shifoujiezhong: '',
					mapixingqing: '',
					mapiaihao: '',
					mapixiangqing: '',
					jiaolianzhanghao: '',
					jiaolianxingming: '',
				},
		
				mapizhongleiOptions: [],
				mapixingbieOptions: [],
				shentizhuangkuangOptions: [],
				shifoujiezhongOptions: [],
				jiaolianzhanghaoOptions: [],

				rules: {
					mapimingzi: [
					],
					mapizhonglei: [
					],
					mapibianhao: [
					],
					tupian: [
					],
					mapixingbie: [
					],
					shentizhuangkuang: [
					],
					mapinianling: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					shifoujiezhong: [
					],
					mapixingqing: [
					],
					mapiaihao: [
					],
					mapixiangqing: [
					],
					jiaolianzhanghao: [
					],
					jiaolianxingming: [
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
						if(o=='mapimingzi'){
							this.ruleForm.mapimingzi = obj[o];
							this.ro.mapimingzi = true;
							continue;
						}
						if(o=='mapizhonglei'){
							this.ruleForm.mapizhonglei = obj[o];
							this.ro.mapizhonglei = true;
							continue;
						}
						if(o=='mapibianhao'){
							this.ruleForm.mapibianhao = obj[o];
							this.ro.mapibianhao = true;
							continue;
						}
						if(o=='tupian'){
							this.ruleForm.tupian = obj[o];
							this.ro.tupian = true;
							continue;
						}
						if(o=='mapixingbie'){
							this.ruleForm.mapixingbie = obj[o];
							this.ro.mapixingbie = true;
							continue;
						}
						if(o=='shentizhuangkuang'){
							this.ruleForm.shentizhuangkuang = obj[o];
							this.ro.shentizhuangkuang = true;
							continue;
						}
						if(o=='mapinianling'){
							this.ruleForm.mapinianling = obj[o];
							this.ro.mapinianling = true;
							continue;
						}
						if(o=='shifoujiezhong'){
							this.ruleForm.shifoujiezhong = obj[o];
							this.ro.shifoujiezhong = true;
							continue;
						}
						if(o=='mapixingqing'){
							this.ruleForm.mapixingqing = obj[o];
							this.ro.mapixingqing = true;
							continue;
						}
						if(o=='mapiaihao'){
							this.ruleForm.mapiaihao = obj[o];
							this.ro.mapiaihao = true;
							continue;
						}
						if(o=='mapixiangqing'){
							this.ruleForm.mapixiangqing = obj[o];
							this.ro.mapixiangqing = true;
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
					}
				}
				// 获取用户信息
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
				this.$http({
					url: `option/mapizhonglei/mapizhonglei`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.mapizhongleiOptions = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
				this.mapixingbieOptions = "公,母".split(',')
				this.shentizhuangkuangOptions = "健康,良好,欠佳".split(',')
				this.shifoujiezhongOptions = "已接种,未接种".split(',')
				this.$http({
					url: `option/jiaolian/jiaolianzhanghao`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.jiaolianzhanghaoOptions = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
			
			},
			// 下二随
			jiaolianzhanghaoChange () {
				this.$http({
					url: `follow/jiaolian/jiaolianzhanghao?columnValue=`+ this.ruleForm.jiaolianzhanghao,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						if(data.data.jiaolianxingming){
							this.ruleForm.jiaolianxingming = data.data.jiaolianxingming
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `mapixinxi/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
						this.ruleForm.mapixiangqing = this.ruleForm.mapixiangqing.replace(reg,'../../../springboot1eev7z37/upload');
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					if(this.ruleForm.tupian!=null) {
						this.ruleForm.tupian = this.ruleForm.tupian.replace(new RegExp(this.$base.url,"g"),"");
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
								url: `mapixinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
											this.parent.mapixinxiCrossAddOrUpdateFlag = false;
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
				this.parent.mapixinxiCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
			tupianUploadChange(fileUrls) {
				this.ruleForm.tupian = fileUrls;
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
