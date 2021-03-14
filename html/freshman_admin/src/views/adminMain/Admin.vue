<template>
	<div class="login_container">
		<div class="login-box">
			<el-form :model="ruleForm"  status-icon :rules="rules" ref="ruleForm" label-width="100px" class="login-ruleForm">

				<el-form-item label="编号" prop="adminId" >
					<el-input v-model="ruleForm.adminId" placeholder="请输入管理员编号"></el-input>
				</el-form-item>

				<el-form-item label="姓名" prop="name">
					<el-input v-model="ruleForm.name" placeholder="请输入姓名"></el-input>
				</el-form-item>

				<el-form-item label="邮箱" prop="mail">
					<el-input v-model="ruleForm.mail" placeholder="请输入邮箱"></el-input>
				</el-form-item>

				<el-form-item label="性别">
					<el-radio-group v-model="ruleForm.sex">
						<el-radio label="男"></el-radio>
						<el-radio label="女"></el-radio>
					</el-radio-group>
				</el-form-item>

				<el-form-item>
					<el-button @click="modify('ruleForm')">修改</el-button>
				</el-form-item>

			</el-form>
		</div>
	</div>

</template>
<script>
  export default {
    data() {
      const validateMail = (rule, value, callback)=>{
        let pattern = /^\w+((.\w+)|(-\w+))@[A-Za-z0-9]+((.|-)[A-Za-z0-9]+).[A-Za-z0-9]+$/;
        if (value === '') {
          callback(new Error('请输入邮箱'))
        }else if(!pattern.test(value)) {
          console.log(pattern.test(value))
          callback(new Error('邮箱格式不正确'))
        }else {
          callback()
        }
      }
      return {
        ruleForm: {
          adminId:'',
          name:'',
          mail:'',
          sex:'男',
        },
        rules: {
          adminId: [
            { required: true, message: '请输入编号', trigger: 'blur' },
            { min:8,max:8, message: '长度为8位数字', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '请输入姓名', trigger: 'blur' },
            { min: 2, max: 4, message: '请正确输入姓名', trigger: 'blur' }
          ],
          mail:[
            { required: true, message: '请输入邮箱', trigger: 'blur' },
            { validator: validateMail, message: '请正确输入邮箱', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '请选择性别', trigger: 'change' }
          ],
        }
      };
    },
    methods: {
      modify(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
    }
  }
</script>

<style type="less" scoped>
	.login_container{
		height: 100%;
	}
	.login-box{
		width: 450px;
		height: 350px;
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
