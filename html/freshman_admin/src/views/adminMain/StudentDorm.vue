<template>
	<div>
		<el-form :inline="true" :model="formInline" class="demo-form-inline">
			<el-form-item >
				<el-input v-model="formInline.classes" placeholder="班级号"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onSubmitClasses">查询</el-button>
			</el-form-item>
			<el-form-item>
				<el-select v-model="formInline.college" placeholder="学院">
					<el-option v-for="item in college" :key="item" :label="item" :value="item"></el-option>
				</el-select>
				<el-button type="primary" @click="onSubmitCollege">查询</el-button>
			</el-form-item>
		</el-form>
		<el-table :data="studentData" class="table" stripe style="width: 709px" :header-cell-style="rowClass" border="true" fit="true">
			<el-table-column prop="dormId" label="宿舍号" width="196px" align="center"></el-table-column>
			<el-table-column prop="name" label="姓名" width="316px" align="center"></el-table-column>
			<el-table-column prop="people" label="人数" width="196px" align="center"></el-table-column>
		</el-table>
	</div>
</template>

<script>
  export default {
    name: 'StudentDorm',
    data(){
      return {
        college:['数学与计算机科学学院','历史与地理旅游学院','经济管理学院','化学与环境学院',
          '文学传播学院','外语学院','教育科学学院', '体育学院','生物学院','物理与电子科学学院'],
        studentData: {
          dormId:'',
          name:'',
          people:''
        },
        formInline: {
          classes: '',
          college: ''
        }
      }
    },
    methods:{
      rowClass({ row, rowIndex}) {
        return 'line-height:20px';
      },
      onSubmitClasses(){

      },
      onSubmitCollege(){

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