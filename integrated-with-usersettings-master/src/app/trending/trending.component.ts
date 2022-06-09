import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-trending',
  templateUrl: './trending.component.html',
  styleUrls: ['./trending.component.css']
})
export class TrendingComponent implements OnInit {

  constructor(private http:HttpClient){}
  gainer:any;
  loser:any;
  readonly url= "http://localhost:3000/nse/get_gainers";
  readonly url2= "http://localhost:3000/nse/get_losers";
  ngOnInit(): void {
    this.gainer={
      "data": [
          {
              "symbol": "SHREECEM",
              "series": "EQ",
              "openPrice": "28,550.00",
              "highPrice": "30,514.85",
              "lowPrice": "28,480.00",
              "ltp": "30,319.95",
              "previousPrice": "28,478.25",
              "netPrice": "6.47",
              "tradedQuantity": "1,40,004",
              "turnoverInLakhs": "41,684.80",
              "lastCorpAnnouncementDate": "22-Jul-2021",
              "lastCorpAnnouncement": "Dividend - Rs 60 Per Share"
          },
          {
              "symbol": "HDFCLIFE",
              "series": "EQ",
              "openPrice": "722.45",
              "highPrice": "775.65",
              "lowPrice": "720.00",
              "ltp": "756.40",
              "previousPrice": "718.55",
              "netPrice": "5.27",
              "tradedQuantity": "1,55,50,968",
              "turnoverInLakhs": "1,17,328.94",
              "lastCorpAnnouncementDate": "30-Jun-2021",
              "lastCorpAnnouncement": "Dividend - Rs 2.02 Per Sh"
          },
          {
              "symbol": "CIPLA",
              "series": "EQ",
              "openPrice": "927.00",
              "highPrice": "957.45",
              "lowPrice": "923.40",
              "ltp": "956.90",
              "previousPrice": "922.85",
              "netPrice": "3.69",
              "tradedQuantity": "33,33,721",
              "turnoverInLakhs": "31,483.33",
              "lastCorpAnnouncementDate": "09-Aug-2021",
              "lastCorpAnnouncement": "Annual General Meeting/Dividend - Rs 5 Per Share"
          },
          {
              "symbol": "TCS",
              "series": "EQ",
              "openPrice": "3,734.00",
              "highPrice": "3,859.15",
              "lowPrice": "3,722.00",
              "ltp": "3,842.35",
              "previousPrice": "3,714.95",
              "netPrice": "3.43",
              "tradedQuantity": "31,37,710",
              "turnoverInLakhs": "1,19,095.23",
              "lastCorpAnnouncementDate": "15-Jul-2021",
              "lastCorpAnnouncement": "Interim Dividend - Rs 7 Per Share"
          },
          {
              "symbol": "ULTRACEMCO",
              "series": "EQ",
              "openPrice": "7,804.80",
              "highPrice": "7,993.95",
              "lowPrice": "7,761.05",
              "ltp": "7,957.55",
              "previousPrice": "7,766.95",
              "netPrice": "2.45",
              "tradedQuantity": "3,73,922",
              "turnoverInLakhs": "29,573.15",
              "lastCorpAnnouncementDate": "02-Aug-2021",
              "lastCorpAnnouncement": "Annual General Meeting/Dividend - Rs 37 Per Share"
          },
          {
              "symbol": "HINDUNILVR",
              "series": "EQ",
              "openPrice": "2,748.00",
              "highPrice": "2,810.00",
              "lowPrice": "2,730.15",
              "ltp": "2,798.55",
              "previousPrice": "2,732.90",
              "netPrice": "2.40",
              "tradedQuantity": "18,13,828",
              "turnoverInLakhs": "50,611.06",
              "lastCorpAnnouncementDate": "14-Jun-2021",
              "lastCorpAnnouncement": "Annual General Meeting/Dividend - Rs 17  Per Sh"
          },
          {
              "symbol": "DRREDDY",
              "series": "EQ",
              "openPrice": "4,811.00",
              "highPrice": "4,904.40",
              "lowPrice": "4,810.00",
              "ltp": "4,864.25",
              "previousPrice": "4,763.45",
              "netPrice": "2.12",
              "tradedQuantity": "12,14,353",
              "turnoverInLakhs": "59,083.74",
              "lastCorpAnnouncementDate": "09-Jul-2021",
              "lastCorpAnnouncement": "Annual General Meeting/Dividend - Rs 25 Per Share"
          },
          {
              "symbol": "NESTLEIND",
              "series": "EQ",
              "openPrice": "19,874.00",
              "highPrice": "20,290.00",
              "lowPrice": "19,761.00",
              "ltp": "20,240.00",
              "previousPrice": "19,826.85",
              "netPrice": "2.08",
              "tradedQuantity": "68,277",
              "turnoverInLakhs": "13,688.33",
              "lastCorpAnnouncementDate": "29-Apr-2021",
              "lastCorpAnnouncement": "Annual General Meeting/Dividend - Rs 65 Per Share"
          },
          {
              "symbol": "SBILIFE",
              "series": "EQ",
              "openPrice": "1,229.80",
              "highPrice": "1,250.00",
              "lowPrice": "1,224.20",
              "ltp": "1,243.45",
              "previousPrice": "1,220.50",
              "netPrice": "1.88",
              "tradedQuantity": "23,16,506",
              "turnoverInLakhs": "28,657.26",
              "lastCorpAnnouncementDate": "05-Apr-2021",
              "lastCorpAnnouncement": "Interim Dividend - Rs 2.5 Per Share"
          },
          {
              "symbol": "KOTAKBANK",
              "series": "EQ",
              "openPrice": "1,752.00",
              "highPrice": "1,777.95",
              "lowPrice": "1,744.00",
              "ltp": "1,777.95",
              "previousPrice": "1,746.65",
              "netPrice": "1.79",
              "tradedQuantity": "54,35,207",
              "turnoverInLakhs": "95,810.20",
              "lastCorpAnnouncementDate": "11-Aug-2021",
              "lastCorpAnnouncement": "Dividend - Rs 0.90 Per Share"
          }
      ],
      "time": "Sep 02, 2021 15:15:19"
  };

    // this.http.get(this.url).subscribe((res)=>{
    //   this.gainer=res;
    // })
    this.loser={
      "data": [
          {
              "symbol": "M&M",
              "series": "EQ",
              "openPrice": "772.85",
              "highPrice": "774.15",
              "lowPrice": "750.00",
              "ltp": "752.65",
              "previousPrice": "769.90",
              "netPrice": "-2.24",
              "tradedQuantity": "45,13,963",
              "turnoverInLakhs": "34,269.56",
              "lastCorpAnnouncementDate": "15-Jul-2021",
              "lastCorpAnnouncement": "Annual General Meeting/Dividend - Rs 8.75 Per Share"
          },
          {
              "symbol": "BAJAJ-AUTO",
              "series": "EQ",
              "openPrice": "3,789.00",
              "highPrice": "3,789.00",
              "lowPrice": "3,717.00",
              "ltp": "3,720.95",
              "previousPrice": "3,758.30",
              "netPrice": "-0.99",
              "tradedQuantity": "4,42,338",
              "turnoverInLakhs": "16,502.92",
              "lastCorpAnnouncementDate": "08-Jul-2021",
              "lastCorpAnnouncement": "Annual General Meeting/Dividend - Rs 140 Per Share"
          },
          {
              "symbol": "ONGC",
              "series": "EQ",
              "openPrice": "118.90",
              "highPrice": "120.15",
              "lowPrice": "118.00",
              "ltp": "118.80",
              "previousPrice": "119.70",
              "netPrice": "-0.75",
              "tradedQuantity": "1,25,48,679",
              "turnoverInLakhs": "14,929.16",
              "lastCorpAnnouncementDate": "17-Feb-2021",
              "lastCorpAnnouncement": "Interim Dividend - Rs 1.75 Per Share"
          },
          {
              "symbol": "DIVISLAB",
              "series": "EQ",
              "openPrice": "5,214.95",
              "highPrice": "5,244.20",
              "lowPrice": "5,153.20",
              "ltp": "5,168.95",
              "previousPrice": "5,202.65",
              "netPrice": "-0.65",
              "tradedQuantity": "3,90,208",
              "turnoverInLakhs": "20,260.34",
              "lastCorpAnnouncementDate": "17-Aug-2021",
              "lastCorpAnnouncement": "Dividend - Rs 20 Per Share"
          },
          {
              "symbol": "TATAMOTORS",
              "series": "EQ",
              "openPrice": "295.25",
              "highPrice": "296.30",
              "lowPrice": "291.70",
              "ltp": "293.50",
              "previousPrice": "295.25",
              "netPrice": "-0.59",
              "tradedQuantity": "1,39,47,600",
              "turnoverInLakhs": "40,976.65",
              "lastCorpAnnouncementDate": "18-Jul-2016",
              "lastCorpAnnouncement": "Dividend - Re 0.20/- Per Share"
          },
          {
              "symbol": "BAJAJFINSV",
              "series": "EQ",
              "openPrice": "16,865.00",
              "highPrice": "16,900.00",
              "lowPrice": "16,610.00",
              "ltp": "16,706.95",
              "previousPrice": "16,786.30",
              "netPrice": "-0.47",
              "tradedQuantity": "2,59,548",
              "turnoverInLakhs": "43,469.62",
              "lastCorpAnnouncementDate": "08-Jul-2021",
              "lastCorpAnnouncement": "Annual General Meeting/Dividend - Rs 3 Per Share"
          },
          {
              "symbol": "IOC",
              "series": "EQ",
              "openPrice": "109.80",
              "highPrice": "110.35",
              "lowPrice": "109.00",
              "ltp": "110.25",
              "previousPrice": "110.75",
              "netPrice": "-0.45",
              "tradedQuantity": "1,09,82,827",
              "turnoverInLakhs": "12,059.14",
              "lastCorpAnnouncementDate": "05-Aug-2021",
              "lastCorpAnnouncement": "Dividend - Rs 1.50 Per Share"
          },
          {
              "symbol": "HEROMOTOCO",
              "series": "EQ",
              "openPrice": "2,725.00",
              "highPrice": "2,738.85",
              "lowPrice": "2,702.60",
              "ltp": "2,729.75",
              "previousPrice": "2,740.85",
              "netPrice": "-0.40",
              "tradedQuantity": "3,96,045",
              "turnoverInLakhs": "10,781.65",
              "lastCorpAnnouncementDate": "22-Jul-2021",
              "lastCorpAnnouncement": "Annual General Meeting/Dividend - Rs 25 Per Share/ Special Dividend - Rs 10 Per Share"
          },
          {
              "symbol": "BAJFINANCE",
              "series": "EQ",
              "openPrice": "7,500.00",
              "highPrice": "7,586.40",
              "lowPrice": "7,445.05",
              "ltp": "7,500.25",
              "previousPrice": "7,519.60",
              "netPrice": "-0.26",
              "tradedQuantity": "11,13,403",
              "turnoverInLakhs": "83,601.31",
              "lastCorpAnnouncementDate": "08-Jul-2021",
              "lastCorpAnnouncement": "Annual General Meeting/Dividend - Rs 10 Per Share"
          },
          {
              "symbol": "HINDALCO",
              "series": "EQ",
              "openPrice": "460.05",
              "highPrice": "465.00",
              "lowPrice": "455.70",
              "ltp": "457.40",
              "previousPrice": "458.10",
              "netPrice": "-0.15",
              "tradedQuantity": "48,33,165",
              "turnoverInLakhs": "22,183.26",
              "lastCorpAnnouncementDate": "12-Aug-2021",
              "lastCorpAnnouncement": "Annual General Meeting/Dividend - Rs 3 Per Share"
          }
      ],
      "time": "Sep 02, 2021 15:17:19"
  }
    // this.http.get(this.url2).subscribe((res)=>{
    //   this.loser=res;
    // })
  }

}
