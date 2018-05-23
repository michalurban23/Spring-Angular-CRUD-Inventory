import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ItemService } from './item/item.service';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { ItemListComponent } from './item/item-list/item-list.component';

@NgModule({
    declarations: [
        AppComponent,
        ItemListComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
    ],
    providers: [ItemService],
    bootstrap: [AppComponent]
})
export class AppModule {}
