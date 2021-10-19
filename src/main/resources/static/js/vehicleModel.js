$('document').ready(function() {

    $('table #editButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (vehicleModel) {
            $('#idEdit').val(vehicleModel.id);
            $('#descriptionEdit').val(vehicleModel.description);
            $('#detailsEdit').val(vehicleModel.details);
        });
        $('#editVehicleModelModal').modal();
    })

    $('table #deleteButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href', href);
        $('#deleteVehicleModelModal').modal();
    })

    $('table #detailsButton').on('click', function (event){
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (vehicleModel) {
            $('#idDetails').val(vehicleModel.id);
            $('#descriptionDetails').val(vehicleModel.description);
            $('#detailsDetails').val(vehicleModel.details);
        })
        $('#detailsVehicleModelModal').modal();
    })
})