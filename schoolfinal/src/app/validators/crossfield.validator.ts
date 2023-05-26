import { AbstractControl } from '@angular/forms';

export function crossfieldValidators(control: AbstractControl): any | null {

    let password = control.get('password');
    let confirmpassword = control.get('confirmpassword');

    console.log(password.value);
    console.log(confirmpassword.value);
    if (confirmpassword.pristine) {
        return null;
    }

    if (password.value === confirmpassword.value) {
        return null;
    }
    else {
        return { 'passworderror': true, 'message': 'password does not match' };
    }

}