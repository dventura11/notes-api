import { Component } from '@angular/core';

@Component({
  selector: 'header-cmp',
  templateUrl: './header.component.html',
})

export class HeaderComponent {
  username:string = '';
  topic:string = '';
  subTopic:string = '';
}
