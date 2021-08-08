var utils = require("../../utils/util.js")
const app = getApp();

Page({

  /**
   * 页面的初始数据
   */

  data: {
    tips: [],
    imgs: [],
    picsrc: [],
    count: 3,
    content: ""
  },
  bindUpload: function (e) {
    switch (this.data.imgs.length) {
      case 0:
        this.data.count = 3
        break
      case 1:
        this.data.count = 2
        break
      case 2:
        this.data.count = 1
        break
    }

    var that = this
    let imgs = that.data.imgs
    let picsrc = that.data.picsrc
    wx.chooseImage({
      count: that.data.count, // 默认4
      sizeType: ["original", "compressed"], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ["album", "camera"], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        var tempFiles = res.tempFiles  // 临时文件对象
        //把选择的图片 添加到集合里
        for (let i in tempFiles) {
          imgs.push(tempFiles[i]);
        }
        for (let i = 0; i < imgs.length; i++) {
          picsrc[i] = imgs[i].path;
        }
        //显示
        that.setData({
          imgs: imgs,
          picsrc: picsrc
        });
        // console.log(imgs);
        console.log(picsrc);

        for (var i = 0; i < picsrc.length; i++) {
          wx.uploadFile({
            url: 'https://', //此处换上你的接口地址
            filePath: picsrc[i],
            name: 'img',
            header: {
              "Content-Type": "multipart/form-data",
            },
            success: function (res) {
              console.log("uploadFile is succes");
            },
            fail: function (res) {
              console.log("uploadFile is fail");
            },
          })
        }
      }
    })
  },
  // 删除图片
  deleteImg: function (e) {
    var that = this
    wx.showModal({
      title: "提示",
      content: "是否删除",
      success: function (res) {
        if (res.confirm) {
          for (var i = 0; i < that.data.imgs.length; i++) {
            if (i == e.currentTarget.dataset.index) that.data.imgs.splice(i, 1)
          }
          that.setData({
            imgs: that.data.imgs
          })
        } else if (res.cancel) {
          console.log("用户点击取消")
        }
      }
    })
  },

  // 预览图片
  previewImg(e) {
    var that = this;
    let picsrc = that.data.picsrc;
    let index = e.currentTarget.dataset.index;
    wx.previewImage({
      //当前显示图片
      current: picsrc[index],
      //所有图片
      urls: picsrc
    })
  },

  forsubmit(e) {
    let form = e.detail.value
    let content = form.content;
    var time = utils.formatTime(new Date());
    this.setData({
      time: time,
    });
    var that = this;
    let tips = that.data.tips;
    // console.log(app.globalData.account);
    that.setData({
      tips:
      {
        userimg: app.globalData.userInfo.avatarUrl,
        username: app.globalData.userInfo.nickName,
        account: app.globalData.account,
        content: content,
        url1: that.data.picsrc[0],
        url2: that.data.picsrc[1],
        url3: that.data.picsrc[2],
        time: time,
      }
    })
    console.log(tips);
    if (form.content) {
      wx.request({
        url: 'http://192.168.1.101:8880/dynamic/updateDynamic',
        data: this.data.tips,
        method: "POST",
        success: (res) => {
          console.log('succes');
          wx.showToast({
            title: '发布成功',
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
        title: '请填写内容',
        icon: 'error'
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