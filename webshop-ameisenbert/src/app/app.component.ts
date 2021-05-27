import { Component, OnInit, OnDestroy  } from '@angular/core';
import { MediaObserver, MediaChange } from '@angular/flex-layout';
import { Subscription } from 'rxjs';
import { map, filter } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'webshop-ameisenbert';

  mediaSub: Subscription | undefined;
  deviceXs: boolean | undefined;
  constructor(public mediaObserver: MediaObserver) {

  }
  ngOnInit() {
    this.mediaSub = this.mediaObserver.asObservable().pipe(
      filter((changes: MediaChange[]) => changes.length > 0),
      map((changes: MediaChange[]) => changes[0])
      )
      .subscribe((change: MediaChange) => {
      console.log(change.mqAlias);
      this.deviceXs = change.mqAlias === "sm" || change.mqAlias === "xs" ? true : false;
    })
  }
  ngOnDestroy() {
    this.mediaSub?.unsubscribe();
  }
}
