//Fill out the Username field
document.addEventListener('DOMContentLoaded', function() {
    const nameInput = document.getElementById('validationCustom01');
    const lastNameInput = document.getElementById('validationCustom02');
    const loginInput = document.getElementById('validationCustomUsername');

    if (nameInput && lastNameInput && loginInput) {
        nameInput.addEventListener('input', updateLogin);
        lastNameInput.addEventListener('input', updateLogin);
    }

    function updateLogin() {
        let name = nameInput.value.toLowerCase();
        name = name.replace(/[^\w\s]/gi, '');
        let lastName = lastNameInput.value.toLowerCase();
        lastName = lastName.replace(/[^\w\s]/gi, '');
        name = name.trim().replace(/\s+/g, '');
        lastName = lastName.trim().replace(/\s+/g, '');
        const login = `${name}.${lastName}`;
        loginInput.value = login;
    }
});

//Show the requirements for the password
document.addEventListener('DOMContentLoaded', function() {
    const passwordInput = document.getElementById('password');
    const passwordRequirements = document.getElementById('passwordRequirements');
    const passwordError = document.getElementById('passwordError');
    const form = document.querySelector('form');

    if (passwordInput && passwordRequirements && passwordError && form) {
        passwordInput.addEventListener('input', function() {
            const password = passwordInput.value;
            let requirements = [];

            // Check password requirements
            if (password.length < 8) {
                requirements.push('At least 8 characters');
            }
            if (!/\d/.test(password)) {
                requirements.push('At least one digit');
            }
            if (!/[A-Z]/.test(password)) {
                requirements.push('At least one uppercase letter');
            }
            if (!/[a-z]/.test(password)) {
                requirements.push('At least one lowercase letter');
            }
            if (!/\W/.test(password)) {
                requirements.push('At least one special character');
            }

            // Update password requirements message
            passwordRequirements.textContent = 'Password must meet the following requirements: ' + requirements.join(', ');

            // Check if requirements are met
            if (requirements.length > 0) {
                passwordError.textContent = 'Please meet the password requirements.';
                passwordInput.setCustomValidity('Invalid');
            } else {
                passwordError.textContent = '';
                passwordInput.setCustomValidity('');
            }
        });

        form.addEventListener('submit', function(event) {
            if (!passwordInput.checkValidity()) {
                event.preventDefault();
                passwordError.textContent = 'Please meet the password requirements.';
            }
        });
    }
});


//Validation Configurations
(() => {
    'use strict'

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    const forms = document.querySelectorAll('.needs-validation')

    // Loop over them and prevent submission
    Array.from(forms).forEach(form => {
        form.addEventListener('submit', event => {
            if (!form.checkValidity()) {
                event.preventDefault()
                event.stopPropagation()
            }

            form.classList.add('was-validated')
        }, false)
    })
})()
// End of the Register Page scripts

// Confirms Post Deletion
function confirmDeletion(){
    return confirm('Are you sure you want to delete this Post?')
}

// Confirms Logout Action
function confirmLogout() {
    return confirm('Are you sure you want to logout?');
}