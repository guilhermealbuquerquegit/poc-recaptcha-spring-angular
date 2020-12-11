import { Account } from './account.model';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css'],
})
export class LogInComponent implements OnInit {
  siteKey: string;
  type: string;
  isLoading = true;
  recaptchaResponse: string;

  public account: Account;


  @ViewChild('captchaElem', { static: false }) captchaElem;

  constructor(private http: HttpClient) {
    this.siteKey = '6Le-SPYZAAAAAHJuWH_DxBWdzlOMXnX5EYmDfiA1';
    this.type = 'image';
  }

  ngOnInit(): void {
    this.account = new Account();
    console.log(this.account);
  }

  getResponse(): void {
    const response = this.captchaElem.getResponse();
    if (!response) {
      console.log('captcha key não corresponde!');
    } else {
      this.isLoading = null;
      this.account.recaptchaResponse = response;
      console.log(response);
    }
  }

  verify(): void {
    this.http
      .post('http://localhost:8080/api/verify', this.account)
      .subscribe((res) => {
        console.log(res);
      });
  }
}
