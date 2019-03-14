import { WebPlugin } from '@capacitor/core';
import { PusherBeamsPlugin } from './definitions';

export class PusherBeamsWeb extends WebPlugin implements PusherBeamsPlugin {
  constructor() {
    super({
      name: 'PusherBeams',
      platforms: ['web', 'android']
    });
  }

  async echo(options: { value: string }): Promise<{value: string}> {
    console.log('ECHO', options);
    return options;
  }

  async setUserID(options: { beamsAuthURL: string, userID: string }): Promise<{ beamsAuthURL: string, userID: string }> {
    return options;
  }
}

const PusherBeams = new PusherBeamsWeb();

export { PusherBeams };
