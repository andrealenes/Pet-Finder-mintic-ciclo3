const modal = document.querySelector('.modal');
const button1 = document.querySelector('#main-button');
const closeButton = document.querySelector('.modal__content--close');
button1.addEventListener('click', () => {
    modal.classList.remove('hidden');
    modal.classList.add('visible');
});

closeButton.addEventListener('click', () => {
    // modal.style.display = 'none';

    modal.classList.remove('visible');
    modal.classList.add('hidden');
});

const modal2 = document.querySelector('.modal2');
const button2 = document.querySelector('#main-button2');
const closeButton2 = document.querySelector('.modal__content--close2');
button2.addEventListener('click', () => {
    modal2.classList.remove('hidden2');
    modal2.classList.add('visible2');
});

closeButton2.addEventListener('click', () => {
    // modal.style.display = 'none';

    modal2.classList.remove('visible2');
    modal2.classList.add('hidden2');
});