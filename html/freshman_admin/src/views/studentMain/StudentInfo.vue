<template>
	<div class="login_container">
		<div class="login-box">
			<el-form :model="student"  status-icon ref="student" label-width="100px" class="login-ruleForm" :disabled="isDisable">

				<el-form-item label="学号" prop="stuId" >
					<el-input v-model="student.stuId"></el-input>
				</el-form-item>

				<el-form-item label="姓名" prop="name">
					<el-input v-model="student.name"></el-input>
				</el-form-item>

				<el-form-item label="性别">
					<el-radio-group v-model="student.sex">
						<el-radio label="男"></el-radio>
						<el-radio label="女"></el-radio>
					</el-radio-group>
				</el-form-item>

				<el-form-item label="学院" prop="college">
					<el-input v-model="student.college"></el-input>
				</el-form-item>

				<el-form-item label="班级" prop="classes">
					<el-input v-model="student.classes"></el-input>
				</el-form-item>

				<el-form-item label="专业" prop="major">
					<el-input v-model="student.major"></el-input>
				</el-form-item>

				<el-form-item label="宿舍" prop="dormId">
					<el-input v-model="student.dormId"></el-input>
				</el-form-item>

				<el-form-item label="学费" prop="payTuition">
					<el-input v-model="student.payTuition"></el-input>
				</el-form-item>

				<el-form-item>
					<el-button type="primary" @click="modify">修改</el-button>
				</el-form-item>
			</el-form>
		</div>
	</div>
</template>

<script>
  export default {
    name: 'StudentInfo',
	  data(){
      return{
        isDisable:true,
        student:[{
          stuId:'',
	        name:'',
	        sex:'',
	        college:'',
	        classes:'',
	        major:'',
	        dormId:'',
	        payTuition:''
        }]
      }
	  },
	  methods:{
      rowClass({ row, rowIndex}) {
        return 'line-height:20px';
      },
      modify(){

      }
	  }
  }
</script>

<style type="less" scoped>
	.login-box{
		width: 440px;
		height: 580px;
		background-color: #fff;
		border-radius: 3px;
		position: absolute;
		left: 50%;
		top:50%;
		transform: translate(-50%,-50%);
	}

	.login-ruleForm{
		position: absolute;
		top:20px;
		bottom: 20px;
		width: 100%;
		padding-right: 120px;
		box-sizing: border-box;
	}


</style>