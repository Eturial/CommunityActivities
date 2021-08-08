// pages/reply/reply.js
var utils = require("../../utils/util.js")
const app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    commentList: []
  },

  inputFocus(e) {
    console.log(e);
    this.setData({ bottom: e.detail.height })
  },
  inputBlur() {
    this.setData({ bottom: 0 })
  },


  getInputValue(e) {
    this.setData({
      commentcontent: e.detail.value,
      userInfo: app.globalData.userInfo
    })
  },


  submit(e) {
    // console.log(e);
    var content = this.data.commentcontent
    var time = utils.formatTime(new Date());
    this.setData({
      time: time,
    });
    this.setData({
      comment: {
        account: app.globalData.account,
        avatarUrl: this.data.userInfo.avatarUrl,
        content: content,
        time: time,
        dyId: this.data.dynamic.dyId
      }
    })
    wx.request({
      url: 'http://192.168.1.101:8880//comment/updateComment',
      method: "POST",
      data: this.data.comment,
      success: (res) => {
        console.log(this.data.comment);
        this.setData({
          commentList: res.data
        })
        wx.navigateBack({
          delta: 1,
        })
        // this.data.commentList.push(this.data.comment)
        // this.setData({
        //   comment_List: this.data.commentList
        // })
        // console.log(this.data.commentList);
      },
      fail: (err) => {
        console.log(err);
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      dynamic: JSON.parse(options.dynamic)
    })
    console.log(this.data.dynamic);
    this.setData({
      dyId: {
        dyId: this.data.dynamic.dyId
      }
    })
    var dynamicdyId = this.data.dyId
    // console.log(this.data.dyId);
    console.log(dynamicdyId);
    wx.request({
      url: `http://192.168.1.101:8880/comment/getAllComment`,
      method: 'GET',
      success: (res) => {
        console.log(res.data);
        this.setData({
          commentList: res.data
        })
      },
      fail: (err) => {
        console.log(err);
      }
    })
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