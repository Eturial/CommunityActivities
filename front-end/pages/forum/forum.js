// var dataObj = require("../data/data.js")

const app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    src: "/images/dz.png",
    // dynamicList: [
    //   {
    //     name: "123",
    //     avatarUrl: "",
    //     content: "123",
    //     dyId: "",
    //     thumb: 0,
    //     commentNum: "2",
    //     time: "2111-1-1",
    //     url1: "/images/admin-h.png",
    //     url2: "/images/admin.png",
    //     url3: "/images/dy.png"
    //   },
    //   {
    //     name: "123",
    //     avatarUrl: "",
    //     content: "123",
    //     dyId: "",
    //     thumb: 0,
    //     commentNum: "2",
    //     time: "2111-1-1",
    //     url1: "",
    //     url2: "",
    //     url3: ""
    //   },
    //   {
    //     name: "123",
    //     avatarUrl: "",
    //     content: "123",
    //     dyId: "",
    //     thumb: 0,
    //     commentNum: "2",
    //     time: "2111-1-1",
    //     url1: "",
    //     url2: "",
    //     url3: ""
    //   },
    // ],
    flag: 1
  },

  goToReply: (e) => {
    console.log(e.currentTarget.dataset.dynamic);
    var id = e.currentTarget.dataset.dynamic;
    var dynamic = JSON.stringify(e.currentTarget.dataset.dynamic)
    wx.navigateTo({
      url: `/pages/reply/reply?dynamic=${dynamic}`,
      success:(res) => {
        wx.request({
          url: 'http://192.168.1.101:8880/comment/getDyId',
          method: 'POST',
          data: {
            dyId: id.dyId
          },
          success:(res) => {
            // console.log(this.data.dyId);
            console.log('post is success');
          },
          fail: (res) => {
            console.log('post is fail');
          }
        })
      }
    })
  },

  goToPublish: (e) => {
    if (app.globalData.postswitch && app.globalData.account) {
      wx.navigateTo({
        url: '/pages/publish/publish',
      })
    }
    else {
      wx.showToast({
        title: '请登录完善资料',
        icon: 'error'
      })
    }
  },

  thumb(e) {
    var dyId = e.currentTarget.dataset
    console.log(e.currentTarget.dataset);
    if (this.data.flag) {
      wx.request({
        url: 'http://192.168.1.101:8880/dynamic/dynamicThumb',
        method: 'POST',
        data: dyId,
        success: (res) => {
          console.log("点赞");
          console.log(dyId);
          this.setData({
            flag: 0,
            // src: "/images/dzcg.png"
          })
        },
        fail: (err) => {
          console.log("点赞失败");
        }
      })

    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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
      postswitch: app.globalData.postswitch
    })
    wx.request({
      url: 'http://192.168.1.101:8880/dynamic/getAllDynamic',
      method: 'GET',
      success: (res) => {
        console.log(res.data);
        this.setData({
          dynamicList: res.data,
        })
        app.globalData.dynamicList = this.data.dynamicList
      },
      fail: (err) => {
        console.log(err);
      }
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