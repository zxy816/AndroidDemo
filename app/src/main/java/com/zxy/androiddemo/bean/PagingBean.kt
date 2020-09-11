package com.zxy.androiddemo.bean

class PagingBean{
    var betResult: String? = null
    var gameIssueInfo: GameIssueInfoBean? = null
    var correctCount = 0
    var channel: ChannelBean? = null
    var ticketStat: String? = null
    var printTicketStatus: PrintTicketStatusBean? = null
    var from: String? = null
    var id = 0
    var stationId: String? = null
    var betNumber: String? = null
    var receiptType: String? = null
    var correctStatus: CorrectStatusBean? = null
    var betMoney: String? = null
    var betMulti: String? = null
    var accountOrderId: String? = null
    var betVirtualStationId: String? = null
    var sysUserId: String? = null
    var channelId = 0
    var settlementType: SettlementTypeBean? = null
    var gameId: String? = null
    var agencyRate = 0
    var multiIssue: String? = null
    var employeeId: String? = null
    var userId: String? = null
    var timeStamp: String? = null
    var betTime: Long = 0
    var macCode: String? = null
    var betIssue: String? = null
    var printTime: Long = 0

    class GameIssueInfoBean {
        /**
         * gameName : 3D
         */
        var gameName: String? = null
    }
    class ChannelBean {
        /**
         * channelName : 监管平台扩容测试
         */
        var channelName: String? = null
    }
    class PrintTicketStatusBean {
        /**
         * name : fail
         */
        var name: String? = null
    }
    class CorrectStatusBean {
        /**
         * name : notCorrect
         */
        var name: String? = null
    }
    class SettlementTypeBean {
        /**
         * name : shared
         */
        var name: String? = null
    }
}