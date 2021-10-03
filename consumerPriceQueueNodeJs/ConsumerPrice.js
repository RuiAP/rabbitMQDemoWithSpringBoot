import amqp from "amqplib";

const queueName = "price";

(async () => {
	try {
		let connection = await amqp.connect({
			host: "localhost",
			port: 5672,
			username: "admin",
			password: 123456,
		});
		let channel = await connection.createChannel();
		channel.consume(
			queueName,
			(message) => {
				console.log(message.content.toString());
			},
			{ noAck: true } //delete/comment to remove messages from the queue when consumed
		);
	} catch (err) {
		console.error(err);
	}
})();
