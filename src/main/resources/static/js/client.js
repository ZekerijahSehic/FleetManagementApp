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
            $('#phoneEdit').val(client.phone);
            $('#mobileEdit').val(client.mobile);
            $('#websiteEdit').val(client.website);
            $('#emailEdit').val(client.email);
            $('#detailsEdit').val(client.details);
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
        $('#phoneDetails').val(client.phone);
        $('#mobileDetails').val(client.mobile);
        $('#websiteDetails').val(client.website);
        $('#emailDetails').val(client.email);
        $('#detailsDetails').val(client.details);
        })
        $('#detailsClientModal').modal();
    })

})