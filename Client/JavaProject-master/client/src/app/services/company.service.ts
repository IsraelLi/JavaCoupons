import { Coupon } from './../models/coupon';
import { Company } from './../models/company';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl = "http://localhost:8080/company";

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  coupon: Coupon = new Coupon()

  constructor(private http: HttpClient) { }

  getAllCoupons(companyId: string): Observable<any> {
    return this.http.get("/api/company/get-all-coupons", {
      params: {
        "company_id": companyId
      }
    })
  }

  createCoupon(coupon: Coupon, companyId: string): Observable<any> {
    return this.http.post("/api/company/create-coupon", coupon, {
      params: {
        "company_id": companyId
      }
    })
  }

  updateCoupon(coupon: Coupon): Observable<any> {
    return this.http.post("/api/company/update-coupon", coupon)
  }

  getCoupon(couponId: string): Observable<any> {
    return this.http.get("/api/company/get-coupon/" + couponId)
  }

  deleteCoupon(couponId: string): Observable<any> {
    return this.http.get("/api/company/delete-coupon/" + couponId)
  }

  getCouponTypes(): Observable<any> {
    return this.http.get("/api/company/get-coupon-types")
  }

  setCouponModel(c: Coupon) {
    this.coupon = c
  }

  getCouponModel() {
    return this.coupon
  }
}
