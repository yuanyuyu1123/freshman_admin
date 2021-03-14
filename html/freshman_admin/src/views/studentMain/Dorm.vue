<template>
	<div>
		<el-table :data="studentDorm" stripe style="width: 60%" :header-cell-style="rowClass">
			<el-table-column prop="dormId" label="宿舍号" align="center"></el-table-column>
			<el-table-column prop="number" label="当前人数"  align="center"></el-table-column>
			<el-table-column prop="cost" label="住宿费" align="center" ></el-table-column>
		</el-table>

		<el-form label-width="100px" class="dorm-ruleForm">
			<el-select v-model="value" placeholder="请选择">
				<el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value" :disabled="item.disabled">
				</el-option>
			</el-select>
			<el-button type="primary" @click="selectValue">确定</el-button>
			</el-form>
	</div>
</template>

<script>
  export default {
    name: 'Dorm',
	  data(){
      return {
        options: [

        ],
        value: '',
        studentDorm:[{
          dormId:'',
	        number:'',
	        cost:''
        }]
      }
	  },
	  methods:{
      rowClass({ row, rowIndex}) {
        return 'line-height:20px';
      },
      selectValue(){

      }
	  }
  }
</script>

<style scoped>
	.dorm-ruleForm{
		padding-top:20px;
		padding-right: 1000px;
	}

</style>