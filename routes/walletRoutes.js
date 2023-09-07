const express = require('express');
const walletController = require('../controllers/walletController');

const router = express.Router();

router.get('/', walletController.wallet);
router.post('/', walletController.wallet_add_post);
router.get('/:id', walletController.wallet_details);
router.delete('/:id', walletController.wallet_delete);

module.exports = router;