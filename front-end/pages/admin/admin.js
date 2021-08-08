// pages/admin/admin.js

const app = getApp();


Page({

  /**
   * 页面的初始数据
   */
  data: {
    hasUserInfo: false,
    userInfo: {},
  },

  goToSport: (e) => {
    wx.navigateTo({
      url: '/pages/sport/sport',
    })
  },

  goToMessage: (e) => {
    wx.navigateTo({
      url: '/pages/message/message',
      success: (res) => {
        wx.request({
          url: 'http://192.168.1.101:8880/comment/getAccount',
          method: 'POST',
          data: {
            account: app.globalData.account
          },
          success: (res) => {
            console.log("post is success");
          },
          fail: (err) => {
            console.log("post is fail");
          }
        })
      }
    })
  },

  goToEdit: (e) => {
    wx.navigateTo({
      url: '/pages/edit/edit',
    })
  },

  getUserProfile(e) {
    // 登录
    // wx.login({
    //   success: res => {
    //     // 发送 res.code 到后台换取 openId, sessionKey, unionId
    //     console.log("code:"+res.code);
    //     if (res.code) {
    //       //发起网络请求
    //       wx.request({
    //         url: 'https://localhost:8888/',
    //         data: {
    //           code: res.code
    //         },
    //         success:res => {
    //           console.log(res.data);
    //         }
    //       })
    //     } else {
    //       console.log('登录失败！' + res.errMsg)
    //     }
    //   }
    // })
    // 推荐使用wx.getUserProfile获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认
    // 开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
    wx.getUserProfile({
      desc: '用于完善会员资料', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: (res) => {
        app.globalData.userInfo = res.userInfo
        app.globalData.postswitch = true
        // console.log(app.globalData.userInfo);
        console.log(app.globalData.postswitch);
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        });
        wx.setStorageSync('userInfo', this.data.userInfo)
        console.log('获取成功');

        // console.log(this.data.hasUserInfo);
        console.log(this.data.userInfo);
      },
      fail: (res) => {
        console.log('获取失败');
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function () {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    this.setData({
      account: app.globalData.account
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})