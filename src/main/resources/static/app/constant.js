var appconstantsmodule = angular.module('tfadmin.appconstantsmodule',[]);

appconstantsmodule.constant('APPCONSTANTS', {
    COMMONMESSAGE: {
        EMAIL_MANDATORY:'Email is mandatory',
        PASSWORD_MANDATORY:'Password is mandatory',
        NOT_VALID_EMAIL:'Not a valid Email Id'
    },
    
    SIGNUP: {
        CONFIRM_PASSWORD_MANDATORY:'Confirm Password is mandatory',
        PASSWORD_NOTMATCHED:'Wrong Password',
        SELECT_TERMS_CONDITIONS:'Please select terms and conditions',
        REGISTER:'Are you sure you want to register with this Email Id? : ',
        DISCRAD_CHANGES:'Are you sure you want to discard the changes?'
    },        
    });