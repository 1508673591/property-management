// pages/msg-detail/index.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    msg: null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var id = options.id;
    this.getDetail(id)
  },

  getDetail(id){
    var that = this;
    wx.showLoading();
    wx.request({
      url: app.globalData.domain + '/api/message/detail',
      data: {id: id},
      success: (res) => {
        if (res.data.code == 0) {
          that.setData({
            msg: res.data.message
          })
        } else {

        }

      },
      complete: function(res) {
        wx.hideLoading();
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