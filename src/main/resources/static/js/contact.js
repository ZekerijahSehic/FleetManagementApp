$('document').ready(function() {

    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (contact) {
            $('#idEdit').val(contact.id);
            $('#nameEdit').val(contact.firstname);
            $('#lastnameEdit').val(contact.lastname);
            $('#phoneEdit').val(contact.phone);
            $('#mobileEdit').val(contact.mobile);
            $('#emailEdit').val(contact.email);
            $('#remarksEdit').val(contact.remarks);
        });
        $('#editContactModal').modal();
    })

    $('table #deleteButton').on('click', function (event) {
        event.preventDefault();
        var href=$(this).attr('href')
        $('#confirmDeleteButton').attr('href', href)
        $('#deleteContactModal').modal()
    })

    $('table #detailsButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (contact) {
            $('#idDetails').val(contact.id);
            $('#nameDetails').val(contact.firstname);
            $('#lastnameDetails').val(contact.lastname);
            $('#phoneDetails').val(contact.phone);
            $('#mobileDetails').val(contact.mobile);
            $('#emailDetails').val(contact.email);
            $('#remarksDetails').val(contact.remarks);
        })
        $('#detailsContactModal').modal();
    })

})