<template>
  <v-container>
    <!-- align=center  justify=center 水平居中， 垂直居中，让整个画面处于中央位置 -->
    <!-- v-row 和 v-col 联用是经典的网格布局 相当于具有响应式的 div -->
    <v-row align="center" justify="center">
      <!-- 定义了col的长度 和 宽度 -->
      <v-col cols="12" sm="10">
        <!-- elevation-6 mt-10 能让card产生凸出来的阴影效果  -->
        <!-- 让整个登录界面突出，并产生影音效果  -->
        <v-card class="elevation-6 mt-10">
          <!-- v-window 主要处理和窗口处理的相关操作 v-window 经常和v-window-item联合使用  -->
          <v-window v-model="step">
            <!-- 第一个页面 item -->
            <v-window-item :value="1">

              <v-row>
                <!-- cols通用屏幕尺寸  md中型屏幕尺寸  -->
                <v-col cols="12" md="6">
                  <v-card-text class="mt-12">
                    <h4 class="text-center">Login in to Your Account</h4>
                    <h6 class="text-center  grey--text ">Log in to your account so you can continue builiding <br>and
                      editing your onboarding flows</h6>
                    <v-row align="center" justify="center">
                      <v-col cols="12" sm="8">

                        <v-text-field label="Email" outlined dense color="blue" autocomplete="false" class="mt-16" />
                        <v-text-field label="Password" outlined dense color="blue" autocomplete="false" type="password" />
                        <v-row>
                          <v-col cols="12" sm="7">
                            <v-checkbox label="Remember Me" class="mt-n1" color="blue"> </v-checkbox>
                          </v-col>
                          <v-col cols="12" sm="5">
                            <span class="caption blue--text">Forgot password</span>
                          </v-col>
                        </v-row>
                        <v-btn color="blue" dark block tile>Log in</v-btn>

                        <h5 class="text-center  grey--text mt-4 mb-3">Or Log in using</h5>
                        <div class="d-flex  justify-space-between align-center mx-10 mb-16">
                          <v-btn depressed outlined color="grey">
                            <v-icon color="red">fab fa-google</v-icon>
                          </v-btn>
                          <v-btn depressed outlined color="grey">
                            <v-icon color="blue">fab fa-facebook-f</v-icon>
                          </v-btn>
                          <v-btn depressed outlined color="grey">
                            <v-icon color="light-blue lighten-3">fab fa-twitter</v-icon>
                          </v-btn>
                        </div>
                      </v-col>
                    </v-row>
                  </v-card-text>
                </v-col>
                <!-- 第一个页面的右边部分提示转到sign up 界面  dont have account yet  -->
                <!-- rounded 是将方块变得圆滑的关键  -->
                <v-col cols="12" md="6" class="blue rounded-bl-xl">
                  <div style="  text-align: center; padding: 180px 0;">
                    <v-card-text class="white--text">
                      <h3 class="text-center ">Don't Have an Account Yet?</h3>
                      <h6 class="text-center">Let's get you all set up so you can start creating your your first<br>
                        onboarding experience</h6>
                    </v-card-text>
                    <div class="text-center">
                      <v-btn tile outlined dark @click="step++">SIGN UP</v-btn>
                    </div>
                  </div>
                </v-col>
              </v-row>
            </v-window-item>
            <!-- 转至第二个页面   -->
            <v-window-item :value="2">
              <!-- 使用网格布局 代替div  -->
              <v-row>
                <!--  cols="12" md="6"  将一个windows 的尺寸平分 -->
                <v-col cols="12" md="6" class="blue rounded-br-xl">
                  <div style="  text-align: center; padding: 180px 0;">
                    <v-card-text class="white--text">
                      <h3 class="text-center ">Alredy Signed up?</h3>
                      <h6 class="text-center">Log in to your account so you can continue building and<br> editing your
                        onboarding flows</h6>
                    </v-card-text>
                    <div class="text-center">
                      <v-btn tile outlined dark @click="step--">Log in</v-btn>
                    </div>
                  </div>
                </v-col>

                <v-col cols="12" md="6">
                  <v-card-text class="mt-12">
                    <h4 class="text-center">Sign Up for an Account</h4>
                    <h6 class="text-center  grey--text ">Let's get you all set up so you can start creatin your <br>
                      first onboarding experiance</h6>
                    <v-row align="center" justify="center">
                      <v-col cols="12" sm="8">
                        <v-row>
                          <v-col cols="12" sm="6">
                            <v-text-field label="First Name" outlined dense color="blue" autocomplete="false"
                              class="mt-4" />
                          </v-col>
                          <v-col cols="12" sm="6">
                            <v-text-field label="Last Name" outlined dense color="blue" autocomplete="false"
                              class="mt-4" />
                          </v-col>
                        </v-row>
                        <v-text-field label="Email" outlined dense color="blue" autocomplete="false" />
                        <v-text-field label="Password" outlined dense color="blue" autocomplete="false" type="password" />
                        <v-row>
                          <v-col cols="12" sm="7">
                            <v-checkbox label="I Accept AAE" class="mt-n1" color="blue"> </v-checkbox>
                          </v-col>
                          <v-col cols="12" sm="5">
                            <span class="caption blue--text ml-n4">Terms &Conditions</span>
                          </v-col>
                        </v-row>
                        <v-btn color="blue" dark block tile>Sign up</v-btn>

                        <h5 class="text-center  grey--text mt-4 mb-3">Or Sign up using</h5>
                        <div class="d-flex  justify-space-between align-center mx-10 mb-11">
                          <v-btn depressed outlined color="grey">
                            <v-icon color="red">fab fa-google</v-icon>
                          </v-btn>
                          <v-btn depressed outlined color="grey">
                            <v-icon color="blue">fab fa-facebook-f</v-icon>
                          </v-btn>
                          <v-btn depressed outlined color="grey">
                            <v-icon color="light-blue lighten-3">fab fa-twitter</v-icon>
                          </v-btn>
                        </div>
                      </v-col>
                    </v-row>
                  </v-card-text>
                </v-col>
              </v-row>
            </v-window-item>

          </v-window>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>


export default {
  data: () => ({
    step: 1
  }),
  props: {
    source: String
  }


}
</script>
<style scoped>
.v-application .rounded-bl-xl {
  border-bottom-left-radius: 300px !important;
}

.v-application .rounded-br-xl {
  border-bottom-right-radius: 300px !important;
}
</style>
