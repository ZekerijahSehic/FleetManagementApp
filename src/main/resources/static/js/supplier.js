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
        $('#websiteDetails').val(supplier.website);
        $('#emailDetails').val(supplier.email);
        })
        $('#detailsSupplierModal').modal();
    })

})