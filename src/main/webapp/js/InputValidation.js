
    document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById("form");
    const submitButton = document.getElementById("submit");

    function validateInput(input, condition) {
    if (condition) {
    input.style.borderColor = "red";
    input.style.outlineColor = "red";
} else {
    input.style.borderColor = "";
    input.style.outlineColor = "";
}
}

    const today = new Date();
    const todayFormatted = today.toISOString().split('T')[0]; // Format: "YYYY-MM-DD"
    console.log(todayFormatted);
    const inputs = [
{ element: document.getElementById("name-input"), condition: (value) => value.trim() === "" },
{ element: document.getElementById("desc-input"), condition: (value) => value.trim() === "" },
{ element: document.getElementById("startdate-input"), condition: (value) => value.trim() === "" || value < todayFormatted },
{ element: document.getElementById("enddate-input"), condition: (value) => value.trim() === "" || new Date(value) < new Date(document.getElementById("startdate-input").value) },
{ element: document.getElementById("budget-input"), condition: (value) => value === "" || value < 1000 }
    ];

    inputs.forEach(input => {
    input.element.addEventListener("input", function () {
    validateInput(input.element, input.condition(input.element.value));
});
});

    form.addEventListener("submit", function (event) {
    let valid = true;

    inputs.forEach(input => {
    if (input.condition(input.element.value)) {
    valid = false;
}
});

    if (!valid) {
    event.preventDefault();
}
});
});

