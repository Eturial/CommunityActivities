// pages/input/input.js

var dataObj = require("../data/data.js")
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    input: {}
  },

  forsubmit(e) {
    var sportid = this.data.sportid
    // console.log(sportid;
    var form = e.detail.value;
    // console.log(form);
    var name = dataObj.activity[sportid].sportname
    var input = this.data.input
    console.log(name);
    if (form.account && form.startTime && form.endTime && form.caption) {
      this.setData({
        input: {
          name: name,
          account: form.account,
          startTime: form.startTime,
          endTime: form.endTime,
          caption: form.caption
        }
      })
      app.globalData.mysport.push(dataObj.activity[sportid])
      console.log(app.globalData.mysport);
      console.log(input);
      wx.request({
        url: 'http://192.168.1.101:8880//apply/addApply',
        data: input,
        method: "POST",
        success: (res) => {
          console.log(res);
          console.log('succes');
          wx.setStorageSync('input',app.globalData.mysport)
          wx.showToast({
            title: '提交成功',
            icon: 'success',
            duration: 2000
          })
          wx.navigateBack({
            delta: 1,
          })
        }
      })
    }
    else {
      wx.showToast({
        title: '请将内容填写完整',
        icon: 'error'
      })
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options);
    this.setData({
      activity: dataObj.activity,
      sportid: options.sportid
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