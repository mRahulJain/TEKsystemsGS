import { Config } from "./config";
import { Question } from "./question";

export class Quiz {
    id: number;
    name: string;
    description: string;
    config: Config;
    questions: Question[];

    constructor(data: any) {
        if (data) {
            this.id = data.id;
            this.name = data.name;
            this.description = data.description;
            this.config = new Config(data.config);
            this.questions = [];
            data.questions.forEach(q => {
                this.questions.push(new Question(q));
            });
        }
    }
}