$('document').ready(function() {

    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (supplier) {
            $('#idEdit').val(supplier.id);
            $('#ddlCountryEdit').val(supplier.countryid);
            $('#ddlRegionEdit').val(supplier.regionid);
            $('#nameEdit').val(supplier.name);
            $('#addressEdit').val(supplier.address);
            $('#cityEdit').val(supplier.city);
            $('#phoneEdit').val(supplier.phone);
            $('#mobileEdit').val(supplier.mobile);
            $('#websiteEdit').val(supplier.website);
            $('#emailEdit').val(supplier.email);
            $('#detailsEdit').val(supplier.details);
        });
        $('#editSupplierModal').modal();
    })

    $('table #deleteButton').on('click', function (event) {
        event.preventDefault();
        var href=$(this).attr('href')
        $('#confirmDeleteButton').attr('href', href)
        $('#deleteSupplierModal').modal()
    })

    $('table #detailsButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (supplier) {
        $('#idDetails').val(supplier.id);
        $('#ddlCountryDetails').val(supplier.countryid);
        $('#ddlRegionDetails').val(supplier.regionid);
        $('#nameDetails').val(supplier.name);
        $('#addressDetails').val(supplier.address);
        $('#cityDetails').val(supplier.city);
        $('#phoneDetails').val(supplier.phone);
        $('#mobileDetails').val(supplier.mobile);
        $('#websiteDetails').val(supplier.website);
        $('#emailDetails').val(supplier.email);
        $('#detailsDetails').val(supplier.details);
        })
        $('#detailsSupplierModal').modal();
    })

})