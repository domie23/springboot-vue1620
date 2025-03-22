<template>
  <div class="addEdit-block">
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
	  :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >
      <el-row>
                        <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="岗位名称" prop="gangweimingcheng">
          <el-input v-model="ruleForm.gangweimingcheng" 
              placeholder="岗位名称" clearable  :readonly="ro.gangweimingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="岗位名称" prop="gangweimingcheng">
              <el-input v-model="ruleForm.gangweimingcheng" 
                placeholder="岗位名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="24">  
        <el-form-item class="upload" v-if="type!='info' && !ro.gongzuohuanjing" label="工作环境" prop="gongzuohuanjing">
          <file-upload
          tip="点击上传工作环境"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.gongzuohuanjing?ruleForm.gongzuohuanjing:''"
          @change="gongzuohuanjingUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.gongzuohuanjing" label="工作环境" prop="gongzuohuanjing">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.gongzuohuanjing.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="岗位要求" prop="gangweiyaoqiu">
          <el-input v-model="ruleForm.gangweiyaoqiu" 
              placeholder="岗位要求" clearable  :readonly="ro.gangweiyaoqiu"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="岗位要求" prop="gangweiyaoqiu">
              <el-input v-model="ruleForm.gangweiyaoqiu" 
                placeholder="岗位要求" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="招聘人数" prop="zhaopinrenshu">
          <el-input v-model="ruleForm.zhaopinrenshu" 
              placeholder="招聘人数" clearable  :readonly="ro.zhaopinrenshu"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="招聘人数" prop="zhaopinrenshu">
              <el-input v-model="ruleForm.zhaopinrenshu" 
                placeholder="招聘人数" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="岗位薪酬" prop="gangweixinchou">
          <el-input v-model="ruleForm.gangweixinchou" 
              placeholder="岗位薪酬" clearable  :readonly="ro.gangweixinchou"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="岗位薪酬" prop="gangweixinchou">
              <el-input v-model="ruleForm.gangweixinchou" 
                placeholder="岗位薪酬" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="工作时间" prop="gongzuoshijian">
          <el-input v-model="ruleForm.gongzuoshijian" 
              placeholder="工作时间" clearable  :readonly="ro.gongzuoshijian"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="工作时间" prop="gongzuoshijian">
              <el-input v-model="ruleForm.gongzuoshijian" 
                placeholder="工作时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="工作地点" prop="gongzuodidian">
          <el-input v-model="ruleForm.gongzuodidian" 
              placeholder="工作地点" clearable  :readonly="ro.gongzuodidian"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="工作地点" prop="gongzuodidian">
              <el-input v-model="ruleForm.gongzuodidian" 
                placeholder="工作地点" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="老师账号" prop="laoshizhanghao">
          <el-input v-model="ruleForm.laoshizhanghao" 
              placeholder="老师账号" clearable  :readonly="ro.laoshizhanghao"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="老师账号" prop="laoshizhanghao">
              <el-input v-model="ruleForm.laoshizhanghao" 
                placeholder="老师账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="老师姓名" prop="laoshixingming">
          <el-input v-model="ruleForm.laoshixingming" 
              placeholder="老师姓名" clearable  :readonly="ro.laoshixingming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="老师姓名" prop="laoshixingming">
              <el-input v-model="ruleForm.laoshixingming" 
                placeholder="老师姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="老师手机" prop="laoshishouji">
          <el-input v-model="ruleForm.laoshishouji" 
              placeholder="老师手机" clearable  :readonly="ro.laoshishouji"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="老师手机" prop="laoshishouji">
              <el-input v-model="ruleForm.laoshishouji" 
                placeholder="老师手机" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                                                  <el-col :span="12">
        <el-form-item class="date" v-if="type!='info'" label="发布时间" prop="fabushijian">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.fabushijian" 
                type="date"
                placeholder="发布时间">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.fabushijian" label="发布时间" prop="fabushijian">
              <el-input v-model="ruleForm.fabushijian" 
                placeholder="发布时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                                                                                                        </el-row>
                                                                                                                                                                                                                                                                                                                                                                                            <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="岗位介绍" prop="gangweijieshao">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.gangweijieshao" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.gangweijieshao" label="岗位介绍" prop="gangweijieshao">
                    <span v-html="ruleForm.gangweijieshao"></span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
                                                                            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    
    
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
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
	  addEditForm: {"btnSaveFontColor":"#fff","selectFontSize":"14px","btnCancelBorderColor":"#DCDFE6","inputBorderRadius":"4px","inputFontSize":"14px","textareaBgColor":"#fff","btnSaveFontSize":"14px","textareaBorderRadius":"4px","uploadBgColor":"#fff","textareaBorderStyle":"solid","btnCancelWidth":"88px","textareaHeight":"120px","dateBgColor":"#fff","btnSaveBorderRadius":"4px","uploadLableFontSize":"14px","textareaBorderWidth":"1px","inputLableColor":"#606266","addEditBoxColor":"rgba(245, 247, 250, 1)","dateIconFontSize":"14px","btnSaveBgColor":"#409EFF","uploadIconFontColor":"#8c939d","textareaBorderColor":"#DCDFE6","btnCancelBgColor":"#ecf5ff","selectLableColor":"#606266","btnSaveBorderStyle":"solid","dateBorderWidth":"1px","dateLableFontSize":"14px","dateBorderRadius":"4px","btnCancelBorderStyle":"solid","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"#C0C4CC","btnCancelHeight":"44px","inputHeight":"40px","btnCancelFontColor":"#606266","dateBorderColor":"#DCDFE6","dateIconFontColor":"#C0C4CC","uploadBorderStyle":"solid","dateBorderStyle":"solid","dateLableColor":"#606266","dateFontSize":"14px","inputBorderWidth":"1px","uploadIconFontSize":"28px","selectHeight":"40px","inputFontColor":"#606266","uploadHeight":"148px","textareaLableColor":"#606266","textareaLableFontSize":"14px","btnCancelFontSize":"14px","inputBorderStyle":"solid","btnCancelBorderRadius":"4px","inputBgColor":"#fff","inputLableFontSize":"14px","uploadLableColor":"#606266","uploadBorderRadius":"4px","btnSaveHeight":"44px","selectBgColor":"#fff","btnSaveWidth":"88px","selectIconFontSize":"14px","dateHeight":"40px","selectBorderColor":"#DCDFE6","inputBorderColor":"#DCDFE6","uploadBorderColor":"#DCDFE6","textareaFontColor":"#606266","selectBorderWidth":"1px","dateFontColor":"#606266","btnCancelBorderWidth":"1px","uploadBorderWidth":"1px","textareaFontSize":"14px","selectBorderRadius":"4px","selectFontColor":"#606266","btnSaveBorderColor":"#409EFF","btnSaveBorderWidth":"1px"},
      id: '',
      type: '',
      ro:{
	gangweimingcheng : false,
	gongzuohuanjing : false,
	gangweiyaoqiu : false,
	zhaopinrenshu : false,
	gangweixinchou : false,
	gongzuoshijian : false,
	gongzuodidian : false,
	laoshizhanghao : false,
	laoshixingming : false,
	laoshishouji : false,
	gangweijieshao : false,
	fabushijian : false,
	sfsh : false,
	shhf : false,
	clicktime : false,
      },
            ruleForm: {
                	        gangweimingcheng: '',
	                        	        gongzuohuanjing: '',
	                        	        gangweiyaoqiu: '',
	                        	        zhaopinrenshu: '',
	                        	        gangweixinchou: '',
	                        	        gongzuoshijian: '',
	                        	        gongzuodidian: '',
	                        	        laoshizhanghao: '',
	                        	        laoshixingming: '',
	                        	        laoshishouji: '',
	                        	        gangweijieshao: '',
	                        	        fabushijian: '',
	                        	                        	        shhf: '',
	                        	        clicktime: '',
	                      },
                                                                                                                                                                                                                              rules: {
                  gangweimingcheng: [
                            { required: true, message: '岗位名称不能为空', trigger: 'blur' },
                                    	                                                              ],
                  gongzuohuanjing: [
                                    	                                                              ],
                  gangweiyaoqiu: [
                            { required: true, message: '岗位要求不能为空', trigger: 'blur' },
                                    	                                                              ],
                  zhaopinrenshu: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                        	                                                              ],
                  gangweixinchou: [
                            { required: true, message: '岗位薪酬不能为空', trigger: 'blur' },
                                    	                                                              ],
                  gongzuoshijian: [
                            { required: true, message: '工作时间不能为空', trigger: 'blur' },
                                    	                                                              ],
                  gongzuodidian: [
                            { required: true, message: '工作地点不能为空', trigger: 'blur' },
                                    	                                                              ],
                  laoshizhanghao: [
                                    	                                                              ],
                  laoshixingming: [
                                    	                                                              ],
                  laoshishouji: [
                                    	                                                              ],
                  gangweijieshao: [
                                    	                                                              ],
                  fabushijian: [
                                    	                                                              ],
                  sfsh: [
                                    	                                                              ],
                  shhf: [
                                    	                                                              ],
                  clicktime: [
                                    	                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                                                                                                                                                                          },
  created() {
	this.addEditStyleChange()
	this.addEditUploadStyleChange()
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
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
          	            if(o=='gangweimingcheng'){
            this.ruleForm.gangweimingcheng = obj[o];
	    this.ro.gangweimingcheng = true;
            continue;
          }
	            	            if(o=='gongzuohuanjing'){
            this.ruleForm.gongzuohuanjing = obj[o];
	    this.ro.gongzuohuanjing = true;
            continue;
          }
	            	            if(o=='gangweiyaoqiu'){
            this.ruleForm.gangweiyaoqiu = obj[o];
	    this.ro.gangweiyaoqiu = true;
            continue;
          }
	            	            if(o=='zhaopinrenshu'){
            this.ruleForm.zhaopinrenshu = obj[o];
	    this.ro.zhaopinrenshu = true;
            continue;
          }
	            	            if(o=='gangweixinchou'){
            this.ruleForm.gangweixinchou = obj[o];
	    this.ro.gangweixinchou = true;
            continue;
          }
	            	            if(o=='gongzuoshijian'){
            this.ruleForm.gongzuoshijian = obj[o];
	    this.ro.gongzuoshijian = true;
            continue;
          }
	            	            if(o=='gongzuodidian'){
            this.ruleForm.gongzuodidian = obj[o];
	    this.ro.gongzuodidian = true;
            continue;
          }
	            	            if(o=='laoshizhanghao'){
            this.ruleForm.laoshizhanghao = obj[o];
	    this.ro.laoshizhanghao = true;
            continue;
          }
	            	            if(o=='laoshixingming'){
            this.ruleForm.laoshixingming = obj[o];
	    this.ro.laoshixingming = true;
            continue;
          }
	            	            if(o=='laoshishouji'){
            this.ruleForm.laoshishouji = obj[o];
	    this.ro.laoshishouji = true;
            continue;
          }
	            	            if(o=='gangweijieshao'){
            this.ruleForm.gangweijieshao = obj[o];
	    this.ro.gangweijieshao = true;
            continue;
          }
	            	            if(o=='fabushijian'){
            this.ruleForm.fabushijian = obj[o];
	    this.ro.fabushijian = true;
            continue;
          }
	            	            	            	            if(o=='clicktime'){
            this.ruleForm.clicktime = obj[o];
	    this.ro.clicktime = true;
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
                                                                                                                                                                                		if(json.laoshizhanghao!=''&&json.laoshizhanghao){
              		this.ruleForm.laoshizhanghao = json.laoshizhanghao
		}
                                  		if(json.laoshixingming!=''&&json.laoshixingming){
              		this.ruleForm.laoshixingming = json.laoshixingming
		}
                                  		if(json.laoshishouji!=''&&json.laoshishouji){
              		this.ruleForm.laoshishouji = json.laoshishouji
		}
                                                                                                                                            } else {
          this.$message.error(data.msg);
        }
      });
                                                                                                                                                                                                                                                                                                            },
                                                                                                                                // 多级联动参数
                                                                                                                                                                  info(id) {
      this.$http({
        url: `gangweigongzuo/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
    },
        // 提交
    onSubmit() {
                  // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                                                                                                                                                                                                                                                                                                                  this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `gangweigongzuo/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.gangweigongzuoCrossAddOrUpdateFlag = false;
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
      this.parent.gangweigongzuoCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
                                    gongzuohuanjingUploadChange(fileUrls) {
                this.ruleForm.gongzuohuanjing = fileUrls;
				this.addEditUploadStyleChange()
            },
                                                                                                                                                                        	addEditStyleChange() {
	  this.$nextTick(()=>{
	    // input
	    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputFontColor
	      el.style.fontSize = this.addEditForm.inputFontSize
	      el.style.borderWidth = this.addEditForm.inputBorderWidth
	      el.style.borderStyle = this.addEditForm.inputBorderStyle
	      el.style.borderColor = this.addEditForm.inputBorderColor
	      el.style.borderRadius = this.addEditForm.inputBorderRadius
	      el.style.backgroundColor = this.addEditForm.inputBgColor
	    })
	    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputLableColor
	      el.style.fontSize = this.addEditForm.inputLableFontSize
	    })
	    // select
	    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectFontColor
	      el.style.fontSize = this.addEditForm.selectFontSize
	      el.style.borderWidth = this.addEditForm.selectBorderWidth
	      el.style.borderStyle = this.addEditForm.selectBorderStyle
	      el.style.borderColor = this.addEditForm.selectBorderColor
	      el.style.borderRadius = this.addEditForm.selectBorderRadius
	      el.style.backgroundColor = this.addEditForm.selectBgColor
	    })
	    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectLableColor
	      el.style.fontSize = this.addEditForm.selectLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
	      el.style.color = this.addEditForm.selectIconFontColor
	      el.style.fontSize = this.addEditForm.selectIconFontSize
	    })
	    // date
	    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateFontColor
	      el.style.fontSize = this.addEditForm.dateFontSize
	      el.style.borderWidth = this.addEditForm.dateBorderWidth
	      el.style.borderStyle = this.addEditForm.dateBorderStyle
	      el.style.borderColor = this.addEditForm.dateBorderColor
	      el.style.borderRadius = this.addEditForm.dateBorderRadius
	      el.style.backgroundColor = this.addEditForm.dateBgColor
	    })
	    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateLableColor
	      el.style.fontSize = this.addEditForm.dateLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
	      el.style.color = this.addEditForm.dateIconFontColor
	      el.style.fontSize = this.addEditForm.dateIconFontSize
	      el.style.lineHeight = this.addEditForm.dateHeight
	    })
	    // upload
	    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
	    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
	      el.style.width = this.addEditForm.uploadHeight
	      el.style.height = this.addEditForm.uploadHeight
	      el.style.borderWidth = this.addEditForm.uploadBorderWidth
	      el.style.borderStyle = this.addEditForm.uploadBorderStyle
	      el.style.borderColor = this.addEditForm.uploadBorderColor
	      el.style.borderRadius = this.addEditForm.uploadBorderRadius
	      el.style.backgroundColor = this.addEditForm.uploadBgColor
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.uploadHeight
	      el.style.color = this.addEditForm.uploadLableColor
	      el.style.fontSize = this.addEditForm.uploadLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
	      el.style.color = this.addEditForm.uploadIconFontColor
	      el.style.fontSize = this.addEditForm.uploadIconFontSize
	      el.style.lineHeight = iconLineHeight
	      el.style.display = 'block'
	    })
	    // 多文本输入框
	    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
	      el.style.height = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaFontColor
	      el.style.fontSize = this.addEditForm.textareaFontSize
	      el.style.borderWidth = this.addEditForm.textareaBorderWidth
	      el.style.borderStyle = this.addEditForm.textareaBorderStyle
	      el.style.borderColor = this.addEditForm.textareaBorderColor
	      el.style.borderRadius = this.addEditForm.textareaBorderRadius
	      el.style.backgroundColor = this.addEditForm.textareaBgColor
	    })
	    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
	      // el.style.lineHeight = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaLableColor
	      el.style.fontSize = this.addEditForm.textareaLableFontSize
	    })
	    // 保存
	    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
	      el.style.width = this.addEditForm.btnSaveWidth
	      el.style.height = this.addEditForm.btnSaveHeight
	      el.style.color = this.addEditForm.btnSaveFontColor
	      el.style.fontSize = this.addEditForm.btnSaveFontSize
	      el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
	      el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
	      el.style.borderColor = this.addEditForm.btnSaveBorderColor
	      el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnSaveBgColor
	    })
	    // 返回
	    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
	      el.style.width = this.addEditForm.btnCancelWidth
	      el.style.height = this.addEditForm.btnCancelHeight
	      el.style.color = this.addEditForm.btnCancelFontColor
	      el.style.fontSize = this.addEditForm.btnCancelFontSize
	      el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
	      el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
	      el.style.borderColor = this.addEditForm.btnCancelBorderColor
	      el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnCancelBgColor
	    })
	  })
	},
	addEditUploadStyleChange() {
		this.$nextTick(()=>{
		  document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
			el.style.width = this.addEditForm.uploadHeight
			el.style.height = this.addEditForm.uploadHeight
			el.style.borderWidth = this.addEditForm.uploadBorderWidth
			el.style.borderStyle = this.addEditForm.uploadBorderStyle
			el.style.borderColor = this.addEditForm.uploadBorderColor
			el.style.borderRadius = this.addEditForm.uploadBorderRadius
			el.style.backgroundColor = this.addEditForm.uploadBgColor
		  })
	  })
	},
  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
  
  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}
</style>
