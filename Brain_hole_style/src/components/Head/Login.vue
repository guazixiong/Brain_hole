<template>
  <div class="paper">
    <div style="margin-top:70px;margin-bottom:50px;">
      账号<input type="text" v-model="phone_or_email"/>
      <span v-if="error.name" class="err-msg">{{error.name}}</span>
    </div>

    <div style="margin-bottom:50px;">
      密码<input type="password" v-model="upassword"/>
      <span v-if="error.pwd" class="err-msg">{{error.name}}</span>
    </div>

    <div style="margin-bottom:50px;">
      <label><input @click="getRadioVal" type="radio" name="type" value=1 v-model="cradio">普通用户</label>
      <label><input @click="getRadioVal" type="radio" name="type" value=2 v-model="cradio">管理员</label>
    </div>

    <div>
      <button @click="login">登录</button>
      <button @click="dialogFormVisible = true">注册</button>
      <el-dialog title="注册" :visible.sync="dialogFormVisible" :modal-append-to-body='false'>

        <el-form label-width="80px">
          <el-form-item label="网名">
            <el-input v-model="uname" placeholder="不能为空"></el-input>
          </el-form-item>

          <el-form-item label="联系方式">
            <el-input v-model="uphone" placeholder="手机号和邮箱不能同时为空"></el-input>
          </el-form-item>

          <el-form-item label="邮箱">
            <el-input v-model="uemail" placeholder="手机号和邮箱不能同时为空"></el-input>
          </el-form-item>

          <el-form-item label="喜好">
            <el-select v-model="value1" multiple placeholder="请选择">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="密码">
            <el-input v-model="upassword2" type="password" placeholder="不能为空"></el-input>
          </el-form-item>

          <el-form-item label="确定密码">
            <el-input v-model="surepassword" type="password" placeholder="不能为空"></el-input>
          </el-form-item>
        </el-form>

        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="onSubmit">确 定</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        phone_or_email: '',
        upassword: '',

        dialogFormVisible: false,
        cradio: '',
        error: {
          name: '',
        },

        uname: '',
        uphone: '',
        uemail: '',
        upassword2: '',
        surepassword: '',

        options: [{
          value: '奇幻玄幻',
          label: '奇幻玄幻'
        }, {
          value: '武侠仙侠',
          label: '武侠仙侠'
        }, {
          value: '历史军事',
          label: '历史军事'
        }, {
          value: '都市娱乐',
          label: '都市娱乐'
        }, {
          value: '科幻游戏',
          label: '科幻游戏'
        }],
        value1: [],
        ufavor: '',

      }
    },
    methods: {
      getRadioVal(event) {
        var x1 = event.target.value;
        console.log(x1);
      },
      //登录
      login() {
        //书友登录
        console.log(this.cradio);
        if (this.cradio == 1) {
          this.$axios({
            method: 'get',
            url: 'http://127.0.0.1:9527/Login?phone_or_email=' + this.phone_or_email + '&upassword=' + this.upassword,
          }).then(response => {
            /*拿到后端传回来的uid值*/
            const data = response.data;
            console.log(data);
            if (data == "用户不存在,请检查你的账号和密码")
              alert(data);
            else {
              //将uid值保存到session对象中
              var obj = data;
              var infostr = JSON.stringify(obj);
              sessionStorage.obj = infostr;
              console.log(obj);
              const {$router} = this;
              $router.push({name: 'UserWeb'});
            }
          }).catch(function (error) {
            alert(error);
          })
        }
        //管理登录(-------)
        else {

        }

      },
      //注册
      onSubmit() {
        console.log(this.value1)
        /*用户选择的喜好,传递过去的是一个数组,将其保存为String,并用","隔开,便于后续的管理和开发*/
        for (let i = 0; i < this.value1.length; i++) {
          this.ufavor += this.value1[i];
          if (i < this.value1.length - 1)
            this.ufavor += ",";
        }
        console.log(this.ufavor)
        /*二次确认密码是否一致*/
        if (this.upassword2 == this.surepassword) {
          this.$axios({
            method: 'get',
            url: 'http://127.0.0.1:9527/register?uname=' + this.uname + '&uphone=' + this.uphone + '&uemail=' + this.uemail + '&upassword=' + this.upassword2 + '&ufavor=' + this.ufavor,
          }).then(response => {
            const data = response.data;
            console.log(data);
            if (data == "输入出现问题,请重新操作"||data=="用户已存在") {
              alert(data);
            }
            else {
              //将uid值保存到session对象中
              var obj = data;
              var infostr = JSON.stringify(obj);
              sessionStorage.obj = infostr;
              console.log(obj);
              //页面跳转
              const {$router} = this;
              $router.push({name: 'UserWeb'});
            }
          })
        }
        else {
          alert("前后密码不一致");
        }

      }
    }
  }
</script>
<style>
  .paper {
    height: 600px;
    width: 100%;
    background-size: cover;
    text-align: center;
    /*position: fixed;*/
  }
</style>
