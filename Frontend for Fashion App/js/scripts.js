document.getElementById('login-form').addEventListener('submit', async function (e) {
    e.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    try {
        const response = await fetch('http://localhost:8080/api/auth/login', { // Update with your backend URL
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ username, password }),
        });

        if (response.ok) {
            const result = await response.text(); // Parse the backend response
            alert(result); // Show success message from the backend
        } else {
            alert('Invalid credentials. Try again!');
        }
    } catch (error) {
        console.error('Error connecting to backend:', error);
        alert('An error occurred while connecting to the server.');
    }
});
document.getElementById('create-account-btn').addEventListener('click', function () {
    // Hide the login form and show the signup form
    document.getElementById('login-form').classList.add('hidden');
    document.getElementById('signup-form').classList.remove('hidden');
});

document.getElementById('signup-form').addEventListener('submit', function (e) {
    e.preventDefault();

    // Get user input
    const username = document.getElementById('signup-username').value;
    const email = document.getElementById('signup-email').value;
    const password = document.getElementById('signup-password').value;

    fetch('http://localhost:8080/api/auth/signup', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, email, password }),
    })
    .then(response => {
        if (response.ok) {
            return response.text();
        } else {
            throw new Error('Please fill correct details');
        }
    })
    .then(message => {
        showPopup(message, true); // Pass true for redirection after successful response
    })
    .catch(error => {
        showPopup(error.message, false); // Pass false to stay on the same page
    });
});

function showPopup(message, shouldRedirect) {
    const popup = document.getElementById('popup');
    const popupMessage = document.getElementById('popup-message');
    popupMessage.textContent = message;
    popup.style.display = 'flex';

    document.getElementById('close-popup').addEventListener('click', function () {
        popup.style.display = 'none';
        if (shouldRedirect) {
            window.location.href = 'login.html'; // Redirect to login page
        }
    });
}