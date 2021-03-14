<template>
	<div class="login_container">
		<div class="login-box">
			<el-form :model="studentPayment"  status-icon ref="ruleForm" label-width="100px" class="login-ruleForm" :disabled="isDisable">

				<el-form-item label="学费" prop="tuition" >
					<el-input v-model="studentPayment.tuition"></el-input>
				</el-form-item>

				<el-form-item label="住宿费" prop="cost">
					<el-input v-model="studentPayment.cost"></el-input>
				</el-form-item>

				<el-form-item label="总费用" prop="sumPayment">
					<el-input v-model="studentPayment.sumPayment"></el-input>
				</el-form-item>

				<el-form-item>
					<el-button type="primary" @click="payment">{{pay}}</el-button>
				</el-form-item>

			</el-form>
		</div>
	</div>

</template>

<script>
  export default {
    name: 'Payment',
	  data(){
      return{
        pay:'支付',
	      isDisabled:true,
        studentPayment:[{
          tuition:'',
	        cost:'',
	        sumPayment:''
        }]
      }
	  },
	  methods:{
      rowClass({ row, rowIndex}) {
        return 'line-height:20px';
      },
      payment(){

      }
	  }
  }
</script>

<style type="less" scoped>
	.login-box{
		width: 440px;
		height: 280px;
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