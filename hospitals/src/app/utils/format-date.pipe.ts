import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'formatDate'
})
export class FormatDatePipe implements PipeTransform {

  transform(value: string, args?: any): any {
    if (value != null) {
      var date: string = value;
      var val: string[] = date.split("-")
        return val[2]+"-"+val[1]+"-"+val[0];
    }
    return null;
  }

}
