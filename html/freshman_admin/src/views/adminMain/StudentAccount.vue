<template>
	<div>
		<el-form :inline="true" :model="formInline" class="demo-form-inline">
			<el-form-item >
				<el-input v-model="formInline.stuId" placeholder="学号"></el-input>
			</el-form-item>
			<el-form-item>
				<el-tooltip content="删除后学生应立即重新注册,原有信息不会丢失!" placement="top-start">
					<el-button type="primary" @click="onSubmitForget">删除密码</el-button>
				</el-tooltip>
			</el-form-item>

			<el-form-item>
				<el-form-item >
					<el-input v-model="formInline.stuId" placeholder="学号"></el-input>
				</el-form-item>
				<el-button type="primary" @click="onSubmitForbid">封禁账号</el-button>
			</el-form-item>

			<el-form-item>
				<el-form-item >
					<el-input v-model="formInline.stuId" placeholder="学号"></el-input>
				</el-form-item>
				<el-button type="primary" @click="onSubmitUnForbid">取消封禁账号</el-button>
			</el-form-item>

		</el-form>
		<el-table :data="studentData" class="table" stripe style="width: 589px" :header-cell-style="rowClass" border="true" fit="true">
			<el-table-column prop="stuId" label="学号" width="196px" align="center"></el-table-column>
			<el-table-column prop="name" label="姓名" width="196px" align="center"></el-table-column>
			<el-table-column prop="forbid" label="封号时间" width="196px" align="center"></el-table-column>
		</el-table>
	</div>
</template>

<script>
  export default {
    name: 'StudentAccount',
    data(){
      return {
        studentData: {
          stuId:'',
          name:'',
	        forbid:''
        },
        formInline: {
          stuId:''
        }
      }
    },
    methods:{
      rowClass({ row, rowIndex}) {
        return 'line-height:20px';
      },
      onSubmitForget(){

      },
      onSubmitForbid(){

      },
	    onSubmitUnForbid(){

      }
    }
  }
</script>

<style scoped>
	.table{
		position: absolute;
		left: 55%;
		top:25%;
		transform: translate(-50%,-50%);
	}

</style>