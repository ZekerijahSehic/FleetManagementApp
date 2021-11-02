$('document').ready(function() {

    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (client) {
            $('#idEdit').val(client.id);
            $('#ddlCountryEdit').val(client.countryid);
            $('#ddlRegionEdit').val(client.regionid);
            $('#nameEdit').val(client.name);
            $('#addressEdit').val(client.address);
            $('#cityEdit').val(client.city);
            $('#mobileEdit').val(client.mobile);
            $('#emailEdit').val(client.email);
            $('#remarksEdit').val(client.remarks);
        });
        $('#editClientModal').modal();
    })

    $('table #deleteButton').on('click', function (event) {
        event.preventDefault();
        var href=$(this).attr('href')
        $('#confirmDeleteButton').attr('href', href)
        $('#deleteClientModal').modal()
    })

    $('table #detailsButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (client) {
        $('#idDetails').val(client.id);
        $('#ddlCountryDetails').val(client.countryid);
        $('#ddlRegionDetails').val(client.regionid);
        $('#nameDetails').val(client.name);
        $('#addressDetails').val(client.address);
        $('#cityDetails').val(client.city);
        $('#mobileDetails').val(client.mobile);
        $('#emailDetails').val(client.email);
        $('#remarksDetails').val(client.remarks);
        })
        $('#detailsClientModal').modal();
    })

})