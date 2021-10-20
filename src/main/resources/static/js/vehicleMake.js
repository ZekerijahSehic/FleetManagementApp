$('document').ready(function() {

    $('table #editButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (vehicleMake) {
            $('#idEdit').val(vehicleMake.id);
            $('#descriptionEdit').val(vehicleMake.description);
            $('#detailsEdit').val(vehicleMake.details);
        });
        $('#editVehicleMakeModal').modal();
    })

    $('table #deleteButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href', href);
        $('#deleteVehicleMakeModal').modal();
    })

    $('table #detailsButton').on('click', function (event){
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (vehicleMake) {
            $('#idDetails').val(vehicleMake.id);
            $('#descriptionDetails').val(vehicleMake.description);
            $('#detailsDetails').val(vehicleMake.details);
        })
        $('#detailsVehicleMakeModal').modal();
    })
})