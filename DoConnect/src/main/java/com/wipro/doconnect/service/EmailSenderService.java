package com.wipro.doconnect.service;
/*@Author:Jaswanth dammalapati
 * Modified Date: 27-08-2022
 * Description:Email Sender Service
 */
public interface EmailSenderService
{
    void sendEmail(String to, String subject, String message);
}
