<template>
	<div class="login_container">
		<div class="login-box">
			<el-form :model="StudentParam"  status-icon :rules="rules" ref="StudentParam" label-width="100px" class="login-ruleForm">

				<el-form-item label="学号" prop="stuId" >
					<el-input v-model="StudentParam.stuId" placeholder="请输入学号"></el-input>
				</el-form-item>

				<el-form-item label="姓名" prop="name">
					<el-input v-model="StudentParam.name" placeholder="请输入名字"></el-input>
				</el-form-item>

				<el-form-item label="性别" prop="sex">
					<el-radio-group v-model="StudentParam.sex">
						<el-radio label="男"></el-radio>
						<el-radio label="女"></el-radio>
					</el-radio-group>
				</el-form-item>

				<el-form-item label="学院" prop="collegeName">
					<el-select v-model="StudentParam.collegeName" placeholder="请选择学院">
						<el-option
										v-for="item in collegeName_options"
										:key="item.value"
										:label="item.label"
										:value="item.value">
						</el-option>
					</el-select>
				</el-form-item>

				<el-form-item label="班级" prop="classes">
					<el-select v-model="StudentParam.classes" placeholder="请选择班级">
						<el-option
										v-for="item in classes_options"
										:key="item.value"
										:label="item.label"
										:value="item.value">
						</el-option>
					</el-select>
				</el-form-item>

				<el-form-item label="密码" prop="password">
					<el-input type="password" v-model="StudentParam.password" autocomplete="off" placeholder="请输入密码(10-19位)"></el-input>
				</el-form-item>

				<el-form-item label="确认密码" prop="checkPassword">
					<el-input type="password" v-model="StudentParam.checkPassword" autocomplete="off" placeholder="请再次输入密码"></el-input>
				</el-form-item>

				<el-form-item>
					<el-button type="primary" @click="submitForm('StudentParam')">注册</el-button>
					<el-button @click="resetForm('StudentParam')">重置</el-button>
					<el-button @click="goLogin">去登录</el-button>
				</el-form-item>

			</el-form>
		</div>
	</div>

</template>
<script>

  import axios from 'axios'

  export default {
    data() {
      const validatorStuId=(rule, value, callback)=>{
        const pattern=/^(21)\d{6}$/;
        if(pattern.test(value)){
          callback()
        }else {
          callback(new Error('请正确输入学号'))
        }
      }
      const validatePassword = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'))
        }else if(value.length<10||value.length>20) {
          callback(new Error('密码长度为10-19个字符'))
        }else {
          if (this.StudentParam.checkPassword !== '') {
            this.$refs.StudentParam.validateField('checkPassword')
          }
          callback()
        }
      }
      const validatePassword2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'))
        } else if (value !== this.StudentParam.password) {
          callback(new Error('两次输入密码不一致!'))
        } else {
          callback()
        }
      }
      return {
        collegeName_options: [
          { value: '数学与计算机科学学院', label: '数学与计算机科学学院' },
          { value: '历史与地理旅游学院', label: '历史与地理旅游学院' },
          { value: '经济管理学院', label: '经济管理学院' },
          { value: '化学与环境学院', label: '化学与环境学院' },
          { value: '文学传播学院', label: '文学传播学院' },
          { value: '外语学院', label: '外语学院' },
          { value: '教育科学学院', label: '教育科学学院' },
          { value: '体育学院', label: '体育学院' },
          { value: '生物学院', label: '生物学院' },
          { value: '物理与电子科学学院', label: '物理与电子科学学院' },
        ],
        classes_options:[
          {value:'1班',label:'1班'},
          {value:'2班',label:'2班'},
          {value:'3班',label:'3班'},
          {value:'4班',label:'4班'},
          {value:'5班',label:'5班'}
        ],
        StudentParam: {
          stuId:'',
          name:'',
          sex:'男',
          collegeName:'',
          classes:'',
          password: '',
          checkPassword: '',
        },
        rules: {
          stuId: [
            { required: true, message: '请输入学号', trigger: 'blur' },
            { validator:validatorStuId, trigger: 'blur' }
          ],
          name: [
            { required: true, message: '请输入姓名', trigger: 'blur' },
            { min: 2, max: 4, message: '请正确输入姓名', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '请选择性别', trigger: 'change' }
          ],
          collegeName:[
            { required: true, message: '请选择学院', trigger: 'blur' },
          ],
          classes:[
            { required: true, message: '请选择班级', trigger: 'blur' },
          ],
          password: [
            {required:true,message:'请输入密码',trigger:'blur'},
            { validator: validatePassword, trigger: 'blur' }
          ],
          checkPassword: [
            {required:true,message:'请再次输入密码',trigger:'blur'},
            { validator: validatePassword2, trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            axios.post('/student/register',{
              stuId:this.StudentParam.stuId,
	            name:this.StudentParam.name,
	            sex:this.StudentParam.sex,
	            collegeName:this.StudentParam.collegeName,
	            classes:this.StudentParam.classes,
	            password:this.StudentParam.password
            }).then((res)=>{
              if(res.data.code==="200"){
                this.$router.push('/student/main')
                //全局存储token
                window.localStorage["token"] = JSON.stringify(res.data.data);
              }else {
                this.$message.error(res.data.msg);
              }
            })
	            .catch(error=>this.$message.error('出错了，请重试...'))
          } else {
            this.$message.error('数据出错了...');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      goLogin(){
				this.$router.push('/student/login')
      }
    }
  }
</script>

<style type="less" scoped>
	.login_container{
		background-color: #324057;
		height: 100%;
	}
	.login-box{
		width: 450px;
		height: 500px;
		background-color: #fff;
		border-radius: 3px;
		position: absolute;
		left: 50%;
		top:50%;
		transform: translate(-50%,-50%);
	}

	.login-ruleForm{
		position: absolute;
		width: 100%;
		bottom: 0;
		padding-right: 80px;
		box-sizing: border-box;
	}

</style>
