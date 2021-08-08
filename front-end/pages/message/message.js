// pages/message/message.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
  
  },

  goToReply: (e) => {
    var dyId = e.currentTarget.dataset.dyId
    var dynamicList = app.globalData.dynamicList
    for (let i = 0; i < dynamicList.length; i++) {
      if (dyId == dynamicList[i].dyId) {
        wx.navigateTo({
          url: `/pages/reply/reply?dynamic=${dynamicList[i]}`
        })
      }
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(app.globalData.account);
    wx.request({
      url: `http://192.168.1.101:8880/comment/getMessage`,
      method: 'GET',
      success: (res) => {
        console.log(res.data);
        this.setData({
          message: res.data
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