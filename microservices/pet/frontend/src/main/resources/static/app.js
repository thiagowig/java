
$(document).ready(function() {

    $("#register-form").submit(function( event ) {

        event.preventDefault();

        var id = $('#id-field').val();
        var message = $('#message-field').val();

        var data = {
                   "userId": id,
                   "message": message
                   };

        $.ajax({
            url: 'http://localhost:8080/register',
            type: 'POST',
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            }).then(function (data, result, response) {
            			console.log('Success')
            		}).catch(function (err) {
            			console.log('Error')
            		})

    });
});