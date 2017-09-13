import { Component } from '@angular/core';

@Component({
  selector: 'header-cmp',
  templateUrl: './header.component.html',
  styleUrls: [ './header.component.css'],
})

export class HeaderComponent {
  topic:string = '';
  subTopic:string = '';
}
