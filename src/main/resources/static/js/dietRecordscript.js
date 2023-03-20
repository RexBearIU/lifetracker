var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"],[data-bs-toggle="modal"]'))
var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
    return new bootstrap.Tooltip(tooltipTriggerEl)
})
// Example starter JavaScript for disabling form submissions if there are invalid fields
// Fetch all the forms we want to apply custom Bootstrap validation styles to
const forms = document.querySelectorAll('.needs-validation');
// Loop over them and prevent submission
Array.prototype.slice.call(forms).forEach((form) => {
    form.addEventListener('submit', (event) => {
        if (!form.checkValidity()) {
            event.preventDefault();
            event.stopPropagation();
        }
        form.classList.add('was-validated')
        form.button.classList.add('[data-bs-dismiss="modal"]');
    }, false);
});


var editButtons = document.querySelectorAll('.edit-row');
for (var i = 0; i < editButtons.length; i++) {
    editButtons[i].addEventListener('click', function () {
        document.getElementById("recordForm").action = "/dietRecord/update"
        var row = this.closest('tr');
        document.querySelector('input[id="dietRecordId"]').value = row.id;
        document.querySelector('input[id="lifeUserId"]').value = document.querySelector('.lifeUserId').id
        document.querySelector('input[id="validationDate"]').value = row.cells[0].textContent;
        document.querySelector('input[id="validationMealTime"]').value = row.cells[1].textContent;
        document.querySelector('input[id="validationFood"]').value = row.cells[2].textContent;
        document.querySelector('input[id="validationFoodContent"]').value = row.cells[3].textContent;
        document.querySelector('input[id="validationPortion"]').value = row.cells[4].textContent;
        document.querySelector('input[id="validationCalories"]').value = row.cells[5].textContent.slice(0, -4);
    });
}
var deleteButtons = document.querySelectorAll('.delete-row');
for (var i = 0; i < deleteButtons.length; i++) {
    deleteButtons[i].addEventListener('click', function () {
        var row = this.closest('tr');
        document.querySelector('input[name="deleteId"]').value = row.id;
    });
}
var createButton = document.querySelector('.create');
createButton.addEventListener('click', function () {
    document.getElementById("recordForm").reset();
    document.querySelector('input[id="lifeUserId"]').value = document.querySelector('.lifeUserId').id
    document.querySelector('input[name="dietRecordId"]').value = null
    document.getElementById("recordForm").action = "/dietRecord/create"
});